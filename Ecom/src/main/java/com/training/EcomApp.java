package com.training;

import java.sql.SQLException;
import java.util.List;

import com.training.dao.DbConnection;
import com.training.dao.ProductDaoImpl;
import com.training.model.Product;

public class EcomApp {

	public static void main(String[] args) {

		try {
			final DbConnection db=DbConnection.getDb();
			final ProductDaoImpl dao=new ProductDaoImpl(db);
//			Display all products			
			printProducts(dao);

			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void printProducts(ProductDaoImpl dao) throws SQLException {
		final List<Product> list=dao.reviewProducts();
		for(Product a: list) {
			System.out.println(a);
		}
		
	}


}

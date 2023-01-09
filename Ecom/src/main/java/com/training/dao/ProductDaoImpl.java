package com.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.training.model.Product;

public class ProductDaoImpl implements IProductDao{
	
	private DbConnection db;
	

	private ProductDaoImpl() {
		super();
	}

	public ProductDaoImpl(DbConnection db) {
		super();
		this.db = db;
	}

	public String addProduct(Product product) throws SQLException {
		final Connection connect=db.getConnection();
		final String sql="Insert into Products values(?,?,?)";
		
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, product.getPid());
		pStatement.setString(2, product.getPname());
		pStatement.setDouble(3, product.getUnitPrice());
		pStatement.executeUpdate();
		pStatement.close();
		
		return null;
	}

	public String updateProduct(Product product) throws SQLException {
		final Connection connect=db.getConnection();
		final String sql="UPDATE PRODUCTS set pname=?, unitPrice=? where pid=?\";";
		final PreparedStatement pstatement=connect.prepareStatement(sql);
		pstatement.setInt(3, product.getPid());
		pstatement.setString(1, product.getPname());
		pstatement.setDouble(2, product.getUnitPrice());
		pstatement.executeUpdate();
		pstatement.close();
		return null;
	}

	public List<Product> reviewProducts() throws SQLException {
		final List<Product> productList=new ArrayList<Product>();
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select pid,pname,unitPrice from products";
		ResultSet resultset=statement.executeQuery(sql);
		while(resultset.next()) {
			final Product product=new Product(resultset.getInt(1), resultset.getString(2), resultset.getDouble(3));
			productList.add(product);
			return productList;
		}
		return null;
	}

}

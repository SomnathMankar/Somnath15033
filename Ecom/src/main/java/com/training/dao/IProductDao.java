package com.training.dao;

import java.sql.SQLException;
import java.util.List;

import com.training.model.Product;

public interface IProductDao {

	public String addProduct(Product product) throws SQLException;
	
	public String updateProduct(Product product) throws SQLException;
	
	public List<Product> reviewProducts() throws SQLException;
	
}

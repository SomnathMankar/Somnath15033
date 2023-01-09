package com.training.dao;

import java.sql.SQLException;
import java.util.List;

import com.training.model.Customer;

public interface ICustomerDao {

	public String registerCustomer(Customer customer) throws SQLException;
	
	public String updateCustomer(Customer customer) throws SQLException;
	
	public List<Customer> reviewCustomer() throws SQLException;
}

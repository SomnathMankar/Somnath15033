package com.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.training.model.Customer;

public class CustomerDaoImpl implements ICustomerDao{
	
	private DbConnection db;
	

	private CustomerDaoImpl() {
		super();
	}
	

	public CustomerDaoImpl(DbConnection db) {
		super();
		this.db = db;
	}



	public String registerCustomer(Customer customer) throws SQLException {
		final Connection connect=db.getConnection();
		final String sql="Insert into Customers values(?,?,?,?,?)";
		
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, customer.getCustid());
		pStatement.setString(2, customer.getCustName());
		pStatement.setString(3, customer.getPhone());
		pStatement.setString(4, customer.getEmail());
		pStatement.setDouble(5, customer.getWalletBalance());
		pStatement.executeUpdate();
		pStatement.close();
		
		return null;
	}

	public String updateCustomer(Customer customer) throws SQLException {
		final Connection connect=db.getConnection();
		final String sql="UPDATE Customers set custName=?, phone=?, email=? where pid=?\";";
		final PreparedStatement pstatement=connect.prepareStatement(sql);
		pstatement.setInt(4, customer.getCustid());
		pstatement.setString(1, customer.getCustName());
		pstatement.setString(2, customer.getPhone());
		pstatement.setString(3, customer.getEmail());
		pstatement.executeUpdate();
		pstatement.close();
		return null;
	}

	public List<Customer> reviewCustomer() throws SQLException {
		final List<Customer> customerList=new ArrayList<Customer>();
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select pid,pname,unitPrice from Products";
		ResultSet resultset=statement.executeQuery(sql);
		while(resultset.next()) {
			final Customer customer=new Customer(resultset.getInt(1), resultset.getString(2), resultset.getString(3), resultset.getString(4), resultset.getDouble(5));
			customerList.add(customer);
			return customerList;
		}
		return null;
	}

}

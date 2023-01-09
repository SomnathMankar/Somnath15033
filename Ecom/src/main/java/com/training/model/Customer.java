package com.training.model;

public class Customer {
	
	private int custid;
	
	private String custName;
	
	private String phone;
	
	private String email;
	
	private double walletBalance;

	public Customer() {
		super();
	}

	public Customer(int custid, String custName, String phone, String email, double walletBalance) {
		super();
		this.custid = custid;
		this.custName = custName;
		this.phone = phone;
		this.email = email;
		this.walletBalance = walletBalance;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getWalletBalance() {
		return walletBalance;
	}

	public void setWalletBalance(double walletBalance) {
		this.walletBalance = walletBalance;
	}

	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", custName=" + custName + ", phone=" + phone + ", email=" + email
				+ ", walletBalance=" + walletBalance + "]";
	}
	
	
	
}

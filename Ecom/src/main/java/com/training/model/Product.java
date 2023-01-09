package com.training.model;

import java.util.List;

public class Product {

	private int pid;
	
	private String pname;
	
	private double unitPrice;

	public Product() {
		super();
	}

	public Product(int pid, String pname, double unitPrice) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.unitPrice = unitPrice;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", unitPrice=" + unitPrice + "]";
	}

	
	
}

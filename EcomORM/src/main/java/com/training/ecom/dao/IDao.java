package com.training.ecom.dao;

import java.util.List;

import com.training.ecom.model.Product;

public interface IDao<T> {

	boolean create(T obj);
	List<T> findAll();
	T findOne(int id);
	boolean findOneAndDelete(int id);
	boolean findOneAndUpdate(int id, T obj);
}

package com.training.ecom.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.training.ecom.model.Product;
import com.training.ecom.util.HibernateUtil;

public class ProductDao implements IDao<Product> {

	private Session session;
	private Transaction transaction;
	private Query query;
	
	
	@Override
	public boolean create(Product product) {

		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		if(session.save(product)!=null) {
			result = true;
		}
		transaction.commit();
		return result;
	}

	

	@Override
	public List<Product> findAll() {
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("from Product");
		final List<Product> productList = query.list();
		transaction.commit();
		return productList;

	}

	@Override
	public Product findOne(int id) {
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("from Product p where p.productId=" + id);
		final Product product = (Product) query.getSingleResult();
		transaction.commit();
		return product;	}

	@Override
	public boolean findOneAndDelete(int id) {
		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("Delete from Product p where p.productId=:id");
		query.setParameter("id", id);
		final int statusDelete = query.executeUpdate();
		transaction.commit();
//		System.out.println("statusDeleted: "+statusDelete);
		if (statusDelete > 0) {
			result = true;
		}
		return result;	}

	@Override
	public boolean findOneAndUpdate(int id, Product product) {
		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("Update Product p set p.productName=:productName where productId=:productId");
		query.setParameter("productName", product.getPname());

		query.setParameter("productId", id);
		final int statusUpdate = query.executeUpdate();
		transaction.commit();
		if (statusUpdate > 0) {
			result = true;
		}
		return result;
	}


	

}

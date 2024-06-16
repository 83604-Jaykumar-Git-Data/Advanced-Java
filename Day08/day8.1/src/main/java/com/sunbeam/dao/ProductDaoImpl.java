package com.sunbeam.dao;

import com.sunbeam.entities.Product;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class ProductDaoImpl implements ProductDao {
	
	@Override
	public String addProduct(Product product) {
		String mesg="product added successfully!!!";
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			
			Serializable productId = session.save(product);
			tx.commit();
			mesg = "product successfully , with ID" +productId;
			
		} catch (RuntimeException e) {
			// TODO: handle exception
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}
	
	@Override
	public Product getProductDetailsById(Long productId) {
		Product product=null;
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			
			product= session.get(Product.class, productId);
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
			// TODO: handle exception
		}
		return product;
	}
}

package com.sunbeam.dao;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductDaoImpl implements ProductDao  {

	@Override
	public String addProduct(Long categoryId, Product newProduct) {
		String mesg = "product not added";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		
		try {
			//3. get category from its id -
			Category category = session.get(Category.class, categoryId);
			if (category != null) {
				// valid category - persistent
				// 4. establish bi dir association between Category n Product
				category.addProduct(newProduct); // state of the category(persistent) is changed !
				session.persist(newProduct); // is this required ??? NO
				
				mesg = "added the product !";
			}
			tx.commit();
			// session.flush() -> dirty checking ->
			// category is modified -> new product entity added.
			// hib : inserts the product
			
		} catch (RuntimeException e) {
			// TODO: handle exception
			if(tx!= null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return mesg;
	}
}

package com.sunbeam.dao;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;


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
	
	@Override
	public List<Product> getAllProducts(){
		String jpql = "select p from Product p";
		List<Product> products = null;
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			products = session.createQuery(jpql,Product.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return products;
	}

	@Override
	public List<Product> getProductDetailsByCategoryAndPrice(double start, double end, Category cat) {
		// TODO Auto-generated method stub
		String jpql = "select p from Product p where p.price between :start and :end and p.category=:cat";
		List<Product> products = null;
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			products = session.createQuery(jpql, Product.class).setParameter("start", start).setParameter("end", end).setParameter("cat", cat).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
			// TODO: handle exception
		}
		return products;
	}

	@Override
	public String applyDiscount(double discount, Category cat) {
		String mesg = "applying discount failed !!!";
		String jpql = "update Product p set p.price=p.price-:disc where p.category=:cat";
		// TODO Auto-generated method stub
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			int rows = session.createQuery(jpql).setParameter("disc", discount).setParameter("cat", cat).executeUpdate();
			
			tx.commit();
			mesg = "Applied discount to users - " + rows;
			
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}	
		return mesg;
	}

//	@Override
//	public String deleteProductDetails(String productName) {
//		String mesg = "Product delete failed !!!";
//		String jpql = "delete Product p where p.productName=:productName ";
//		// TODO Auto-generated method stub
//		Session session = getFactory().getCurrentSession();
//		Transaction tx = session.beginTransaction();
//
//		try {
//			int rows = session.createQuery(jpql).setParameter("productName", productName).executeUpdate();
//			
//			tx.commit();
//			mesg = "Product deleted successfully - " + rows;
//			
//		} catch (RuntimeException e) {
//			if(tx != null)
//				tx.rollback();
//			throw e;
//		}	
//		return mesg;
//	}
	
	
//	OR
	
	
	@Override
	public String deleteProductDetails(String productName) {
		 String msg = "Deleting Failed";
		 Product p = null;
		 String jpql = "select p from Product p where p.productName =:productName";
	        Session session = getFactory().getCurrentSession();
		    Transaction tx= session.beginTransaction();
		    
		    try {
              p = session.createQuery(jpql,Product.class).setParameter("productName", productName).getSingleResult();				
				
				   session.delete(p);
					msg = "Product Deleted Successfully";
				
				tx.commit();
			} catch (RuntimeException e) {
				if (tx != null)
					tx.rollback();
				throw e;
			}
			return msg;
	}

	@Override
	public String purchaseAproduct(Long productId, int qty) {
		// TODO Auto-generated method stub
		String mesg = "purchase failed";
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			Product product = session.get(Product.class, productId);
			
			if(product != null) {
				product.setQty(product.getQty() -qty);
				mesg = "product purchased successfully";
			}
			tx.commit();
			
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
			// TODO: handle exception
		}
		return mesg;
	}
	
	
}

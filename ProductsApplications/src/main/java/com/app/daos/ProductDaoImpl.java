package com.app.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.Utils.HibernateUtils;
import com.app.pojos.Category;
import com.app.pojos.Product;

public class ProductDaoImpl implements ProductDao {

	Session session = null;

	@Override
	public String insertProduct(Product product) {
		session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String message = "product add is failed!!";
		try {
                Long id = (Long) session.save(product);
			   tx.commit();
			message = "product add is Successfully!!" + id;
		} catch (Exception e) {

			tx.rollback();
			throw e;
		}
		return message;
	}

	@Override
	public Product fetchProduct(Long id) {
		session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		Product product = null;
		try {
              product = session.get(Product.class, id);
			   tx.commit();
		} catch (Exception e) {

			tx.rollback();
			throw e;
		}
		return product;
}

	@Override
	public List<Product> fetchAllProducts() {
		session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Product> productList = null;
		String jpql = "select p from Product p";
		try {
              productList = session.createQuery(jpql, Product.class).getResultList();
              //productList is a presistant list data
			   tx.commit();
		} catch (Exception e) {

			tx.rollback();
			throw e;
		}
		return productList;
	}

	@Override
	public List<Product> getProductsByCategory(Category category) {
		session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Product> productList = null;
		String jpql = "select p from Product p where p.category=:category";
		try {
              productList = session.createQuery(jpql, Product.class).setParameter("category", category).getResultList();
              //productList is a presistant list data
			   tx.commit();
		} catch (Exception e) {

			tx.rollback();
			throw e;
		}
		return productList;
	}

	@Override
	public List<Integer> getProductsByAvailableQuantity(Category category) {
		session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Integer> productAvailableQuantity = null;
		String jpql = "select p.isAvailableQuantity from Product p where p.category=:category";
		try {
			productAvailableQuantity = session.createQuery(jpql, Integer.class).setParameter("category", category).getResultList();
              //productList is a presistant list data
			   tx.commit();
		} catch (Exception e) {

			tx.rollback();
			throw e;
		}
		return productAvailableQuantity;
	}

	@Override
	public List<Product> getProductJPACtorExpression(Category category) {
		session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Product> productList = null;
		String jpql = "select new com.app.pojos.Product(productName,price,isAvailableQuantity) from Product p where p.category=:category";
		try {
			productList = session.createQuery(jpql, Product.class).setParameter("category", category).getResultList();
              //productList is a presistant list data
			   tx.commit();
		} catch (Exception e) {

			tx.rollback();
			throw e;
		}
		return productList;
	}

	@Override
	public String updateProductAvailableQuantity(Long id, int availableQuantity) {
				Session session=HibernateUtils.getSessionFactory().getCurrentSession();
				Transaction tx=session.beginTransaction();
				String mesg = "failed Updations!!";
				try {
					     session.get(Product.class, id).setIsAvailableQuantity(availableQuantity);;
					tx.commit();
					mesg = "successfully done updations!!";
				} catch (RuntimeException e) {
					if(tx != null)
						tx.rollback();
					throw e;
				}
				return mesg;
	}

	@Override
	public String updateProductAvailableQuantityByValue(Category category, int value) {
				Session session=HibernateUtils.getSessionFactory().getCurrentSession();
				Transaction tx=session.beginTransaction();
				String mesg = "failed Updations!!";
				String jpql = "update Product p set p.isAvailableQuantity = p.isAvailableQuantity + :value where p.category = :category";
				try {
					   int row = session.createQuery(jpql).setParameter("category", category).setParameter("value", value).executeUpdate();
					tx.commit();
					mesg = "successfully done updations!!" + row;
				} catch (RuntimeException e) {
					if(tx != null)
						tx.rollback();
					throw e;
				}
		return mesg;
	}

	@Override
	public String deleteUserDetails(String productName) {
		Session session=HibernateUtils.getSessionFactory().getCurrentSession();
		String jpql = "delete from Product p where p.productName = :productName";
		Transaction tx=session.beginTransaction();
		String mesg = "Deletion has failed!! ";
		try {
			  int row = session.createQuery(jpql).setParameter("productName", productName).executeUpdate();
			tx.commit();
			mesg="Deletion has Successfully!!";
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String deleteUserDetails(Long userId) {
				Session session=HibernateUtils.getSessionFactory().getCurrentSession();
				Transaction tx=session.beginTransaction();
				String mesg = "Deletion has failed!! ";
				try {
					  Product product = session.get(Product.class, userId);
					  if(product != null)
					  {
						  session.delete(product);
						  mesg="Deletion has Successfully!!";
					  }
					tx.commit();
				} catch (RuntimeException e) {
					if(tx != null)
						tx.rollback();
					throw e;
				}
				return mesg;
	}

}

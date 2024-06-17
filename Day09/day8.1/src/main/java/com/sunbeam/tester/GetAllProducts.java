package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;


public class GetAllProducts {
	public static void main(String[] args) {
		try (SessionFactory sf = getFactory()) {
			// create dao instance
			ProductDao dao = new ProductDaoImpl();
			dao.getAllProducts() //List<User>
			.forEach(System.out::println);//u -> System.out.println(u)
		} // JVM : sc.close() , sf.close() -> DBCP will be cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}

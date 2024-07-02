package com.app.Utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lombok.Getter;

public final class HibernateUtils {
   private static SessionFactory sessionFactory;
   
   static {
	   sessionFactory = new Configuration().configure().buildSessionFactory();
   }
   
   public static SessionFactory getSessionFactory() {
	return sessionFactory;
}
}

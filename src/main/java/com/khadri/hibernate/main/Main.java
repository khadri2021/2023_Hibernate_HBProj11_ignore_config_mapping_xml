package com.khadri.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.khadri.hibernate.annotation.Remote;

public class Main {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		
		//Hibernate configuration hard coded
		cfg.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/2022batch");
		cfg.setProperty("hibernate.connection.username", "root");
		cfg.setProperty("hibernate.connection.password", "root");
		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		cfg.setProperty("hibernate.show_sql", "true");
		cfg.setProperty("hibernate.hbm2ddl.auto", "update");
		
		//Entity Mapping
		cfg.addAnnotatedClass(Remote.class);//entity resource mapping in java

		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();

		Transaction txn = session.beginTransaction();

		Remote remote = new Remote();
		remote.setId(2);
		remote.setName("MI-Redmi");

		session.save(remote);
		
		txn.commit();
		session.close();
		factory.close();

	}
}

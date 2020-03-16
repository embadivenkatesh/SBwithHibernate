package com.training.springboothibernate;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SpringboothibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringboothibernateApplication.class, args);
	}
	
	/*
	 * @Bean public SessionFactory sessionFactory(HibernateEntityManagerFactory
	 * hemf) { return hemf.getSessionFactory(); }
	 */
}

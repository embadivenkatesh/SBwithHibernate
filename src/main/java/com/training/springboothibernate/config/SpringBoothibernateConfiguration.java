package com.training.springboothibernate.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages= {"com.training.springboothibernate.controller","com.training.springboothibernate.service","com.training.springboothibernate.entity"})
public class SpringBoothibernateConfiguration {
	
	    @Autowired
	    private DataSource datasource;
	    
	    @Bean
	    @Primary
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactorybean=new LocalSessionFactoryBean();
	        sessionFactorybean.setDataSource(datasource);
	        sessionFactorybean.setPackagesToScan("com.training.springboothibernate.entity");
	        sessionFactorybean.setHibernateProperties(HibernateProperties());
	        return sessionFactorybean;
	    }
	    
	    
	    @Bean
	    public Properties HibernateProperties() {
	        Properties prop=new Properties();
	        prop.setProperty("hibernate.hbm2ddl.auto", "create-drop");
	        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	        return prop;
	    }
	    @Bean
	    public PlatformTransactionManager hibernateTransactionManager() {//
	        HibernateTransactionManager transactionManager=new HibernateTransactionManager();
	        transactionManager.setSessionFactory(sessionFactory().getObject());
	        return transactionManager;
	    }
	    @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	        LocalContainerEntityManagerFactoryBean emfbean=new LocalContainerEntityManagerFactoryBean();
	        emfbean.setDataSource(datasource);
	        emfbean.setPackagesToScan("com.training.springboothibernate.entity");
	        JpaVendorAdapter hibernateAdopter=new HibernateJpaVendorAdapter();
	        emfbean.setJpaVendorAdapter(hibernateAdopter);
	        emfbean.setJpaProperties(HibernateProperties());
	        return emfbean;
	        
	    }
	    
	    
	    
	    
	    
	}
	



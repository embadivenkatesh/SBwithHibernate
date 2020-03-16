package com.training.springboothibernate.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.springboothibernate.entity.Book;

@Repository
public class BookDao  {
	
	@Autowired
    SessionFactory sf;
 
    public Book createBook(Book book) {
        Session s = sf.getCurrentSession();
         
        s.beginTransaction();
         s.persist(book);
        s.getTransaction().commit();
         
        return book;
    }
 
   
    @SuppressWarnings({ "deprecation", "unchecked" })
    public List<Book> findAll() {
        Session s = sf.getCurrentSession();
        List<Book> list = s.createCriteria(Book.class).list();
        return list;
    }
 
    public Book findById(int bookid) {
        Session s = sf.getCurrentSession();
        Book book = s.get(Book.class, bookid);
        return book;
    }
}



package com.example.demo.service;

import com.example.demo.persistence.Author;
import com.example.demo.persistence.AuthorRepo;
import com.example.demo.persistence.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

public class AuthorService {
    @Autowired
    AuthorRepo authorRepo;
    @Autowired
    BookRepository bookRepository;
    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;
    @PersistenceContext
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    /*Author findByBookTitle(String title){
        bookRepository.findByTitle(title);
        authorRepo.

    }*/
}

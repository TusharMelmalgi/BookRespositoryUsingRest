package com.example.demo.service;

import com.example.demo.web.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.demo.persistence.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService implements BookServiceInterface{

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookServiceTest bookServiceTest;
    @PersistenceUnit
    EntityManagerFactory entityManagerFactory ;

    @Override
    @Transactional
    public Books createBook(Books books) {
        bookRepository.save(books);
        System.out.println("book successfully saved");
        return books;
    }

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Books> findAll() {
        System.out.println("The books in repo are");
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Books> cq = cb.createQuery(Books.class);
        Root<Books> book = cq.from(Books.class);
        cq.select(book);
        TypedQuery<Books> q = entityManager.createQuery(cq);
        List<Books> allBooks = q.getResultList();
        return allBooks;
    }

    @Override
    public List findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public Books findById(Long id) {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
        bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    @Override
    @Transactional
    public void update(Books books,Long id) {
        bookRepository.save(books);
        System.out.println("saved book");
        bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }
}

package com.example.demo.service;

import com.example.demo.persistence.BookRepository;
import com.example.demo.persistence.Books;
import com.example.demo.web.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BookServiceTest {

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public void findBookById(Long id){
        bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }
    @Transactional
    public void deleteBooks(Long id){
        bookRepository.deleteById(id);
    }
}

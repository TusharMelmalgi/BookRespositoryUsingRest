package com.example.demo.service;
import com.example.demo.persistence.*;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import java.util.List;

public interface BookServiceInterface {
    public Books createBook(Books books);
    public Iterable findAll();
    public List findByTitle(String title);
    public Books findById(Long id);
    public void deleteById(Long id);
    public void update(Books books,Long id);

}

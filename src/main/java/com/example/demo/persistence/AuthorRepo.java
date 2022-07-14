package com.example.demo.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
@Repository
public interface AuthorRepo extends CrudRepository<Author, Long> {
    List<Author> findAll();
}

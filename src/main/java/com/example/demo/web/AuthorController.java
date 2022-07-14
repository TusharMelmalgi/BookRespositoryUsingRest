package com.example.demo.web;

import com.example.demo.persistence.Author;
import com.example.demo.persistence.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/author")
public class AuthorController {
    @Autowired
    private AuthorRepo authorRepo;

    @GetMapping()
    public ResponseEntity<Object> findAll(){
       return new ResponseEntity<Object>(authorRepo.findAll() ,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Object> createAuthor(@RequestBody Author author){
        authorRepo.save(author);
        return new ResponseEntity<Object>(author,HttpStatus.CREATED);
    }
}

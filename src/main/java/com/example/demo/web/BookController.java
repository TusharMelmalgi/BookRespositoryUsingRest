package com.example.demo.web;

import com.example.demo.persistence.Author;
import com.example.demo.persistence.AuthorRepo;
import com.example.demo.persistence.BookRepository;
import com.example.demo.persistence.Books;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorRepo authorRepo;
    @GetMapping
    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<>(bookService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/title/{bookTitle}")
    public ResponseEntity<Object> findByTitle(@PathVariable String title){

        return new ResponseEntity<>(bookService.findByTitle(title),HttpStatus.OK);
    }
    @GetMapping("/author/{bookAuthor}")
    public ResponseEntity<Object> findByAuthor(@PathVariable String author){
        return new ResponseEntity<>(bookRepository.findByAuthor(author),HttpStatus.OK);
    }
    /*@GetMapping("/id/{id}")
    public ResponseEntity<Object> findByidGT(@PathVariable Long id){
        return new ResponseEntity<>(bookRepository.findByIDGT(id),HttpStatus.OK);
    }*/

    @GetMapping("/{id}")
    public Books findOne(@PathVariable Long id){
        return bookService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Books create(@Valid @RequestBody Books books){
        System.out.println("Saving book to repository...");
        bookService.createBook(books);
        return books;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        bookService.deleteById(id);
        return new ResponseEntity<>("Book deleted Succesfully",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@Valid@RequestBody Books books,@PathVariable Long id){
        bookService.update(books,id);
        return new ResponseEntity<>("Book updated Successfully",HttpStatus.OK);
    }
    /*@PutMapping(value = "/authors/{id}",consumes = "text/uri")
    public ResponseEntity<Object> addAuthor(@Valid@RequestBody Author author, @PathVariable long id){
        Optional<Books> books = bookRepository.findById(id);

    }*/

}

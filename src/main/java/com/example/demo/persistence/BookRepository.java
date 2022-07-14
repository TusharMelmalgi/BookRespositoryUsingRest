package com.example.demo.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends CrudRepository<Books , Long> {
    List<Books> findByTitle(String title);
    List<Books> findByAuthor(String author);

    @Query(value = "from Books b order by title")
    @Override
    List<Books> findAll();

    /*@Query(value = "from Books b where b.id>2 order by b.name")
    List<Books> findByIDGT(Long id);*/
}

package com.example.orm.repository;

import com.example.orm.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Spring Data JPA automatically provides basic CRUD operations.

    Optional<Book> findByTitle(String title);
    // TODO: Add a custom query method to find books by title
    // Optional<Book> findByTitle(String title);

    List<Book> findByAuthor(Author author);
    // TODO: Add a custom query method to find books by the author's name
    // List<Book> findByAuthorName(String authorName);

    // You can also define custom queries using @Query annotation for more complex scenarios.
}
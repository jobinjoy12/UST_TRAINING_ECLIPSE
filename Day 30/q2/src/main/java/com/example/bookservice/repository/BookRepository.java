package com.example.bookservice.repository;

import com.example.bookservice.model.Book;

import java.util.List;
import java.util.Optional;

// TODO: 3. Create a Repository/Service Layer
// Create an interface `BookRepository`.
// Implement methods for:
// - `List<Book> findAll()`: Returns all books.
// - `Optional<Book> findById(Long id)`: Returns a book by its ID.
// - `Book save(Book book)`: Adds a new book or updates an existing one.
// - `void deleteById(Long id)`: Deletes a book by its ID.
public interface BookRepository {
    // TODO: Define method signatures for findAll(), findById(Long id), save(Book book), deleteById(Long id)
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Book save(Book book);
    void deleteById(Long id);
}
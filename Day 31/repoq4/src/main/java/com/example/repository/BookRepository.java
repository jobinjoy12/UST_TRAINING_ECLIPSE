package com.example.repository;

import java.util.List;

public interface BookRepository {
    void addBook(Book book);
    Book findBookById(String id);
    List<Book> findAllBooks();
    void updateBook(Book book);
    void deleteBook(String id);
}
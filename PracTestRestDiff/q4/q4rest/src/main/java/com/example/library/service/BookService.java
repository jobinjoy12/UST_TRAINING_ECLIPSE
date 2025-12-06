package com.example.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findBooksPublishedAfterYear(int year) {
        List<Book> book = bookRepository.findBooksPublishedAfter(year);
        return book; // Placeholder
    }
}
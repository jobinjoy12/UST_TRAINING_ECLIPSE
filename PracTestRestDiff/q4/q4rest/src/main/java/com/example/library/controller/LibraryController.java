package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.model.Library;
import com.example.library.service.BookService;
import com.example.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libraries")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Library> createLibrary(@RequestBody Library library) {
        Library createdLibrary = libraryService.createLibrary(library);
        return new ResponseEntity<>(createdLibrary, HttpStatus.CREATED);
    }

    @PostMapping("/{libraryId}/books")
    public ResponseEntity<Book> addBookToLibrary(@PathVariable Long libraryId, @RequestBody Book book) {
        Book addedBook = libraryService.addBookToLibrary(libraryId, book);
        if (addedBook == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Library not found with id " + libraryId);
        }
        return new ResponseEntity<>(addedBook, HttpStatus.CREATED);
    }

    @GetMapping("/{libraryId}/books")
    public ResponseEntity<List<Book>> getBooksByLibrary(@PathVariable Long libraryId) {
        List<Book> books = libraryService.getBooksByLibraryId(libraryId);
        if (books == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Library not found with id " + libraryId);
        }
        return ResponseEntity.ok(books);
    }

    @GetMapping("/books/after/{year}")
    public ResponseEntity<List<Book>> getBooksPublishedAfter(@PathVariable int year) {
        List<Book> books = bookService.findBooksPublishedAfterYear(year);
        return ResponseEntity.ok(books);
    }
}
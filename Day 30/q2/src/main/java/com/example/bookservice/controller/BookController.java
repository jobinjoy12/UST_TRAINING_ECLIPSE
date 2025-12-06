package com.example.bookservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;DeleteMapping
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
comexamplebookservice.model.Book
import com.example.bookservice.repository.BookRepository;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;

// TODO: 4. Develop the Book REST Controller
// Create a REST Controller class named `BookController`.
// Annotate the class with `@RestController` and `@RequestMapping("/api/books")`.
// Inject your `BookRepository` into the controller.
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // TODO: Implement GET /api/books - Returns a list of all books.
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookRepository.findAll()); // TODO: Return a list of all books with HttpStatus.OK
    }

    // TODO: Implement GET /api/books/{id} - Returns a specific book by its ID.
    // Handle the case where the book is not found (e.g., return HttpStatus.NOT_FOUND).
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        return bookOpt.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.status(HttpStatus.NOT_FOUND).build()); // TODO: Return the book if found, else return HttpStatus.NOT_FOUND
    }

    // TODO: Implement POST /api/books - Adds a new book to the collection.
    // The book details will be sent in the request body.
    // Return the newly created book with its assigned ID and an HttpStatus.CREATED.
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book book1 = bookRepository.save(book);

        return new ResponseEntity<Book>(HttpStatus.CREATED); // TODO: Save the new book and return it with HttpStatus.CREATED
    }

    // TODO: Implement PUT /api/books/{id} - Updates an existing book identified by `id`.
    // The updated book details will be sent in the request body.
    // Handle the case where the book is not found.
    // Return the updated book.
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Optional<Book> opt = bookRepository.findById(id);
        if(opt.isPresent())
        {
            Book book1 = opt.get();
            return ResponseEntity.ok(bookRepository.save(book));

        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND).build(); // TODO: Update the book if found, else return HttpStatus.NOT_FOUND
    }

    // TODO: Implement DELETE /api/books/{id} - Deletes a book by its ID.
    // Handle the case where the book is not found.
    // Return an HttpStatus.NO_CONTENT on successful deletion.
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Optional<Book> opt = bookRepository.findById(id);
        if(opt.isPresent())
        {
            Book book1 = opt.get();
            bookRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT).build();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND).build() ; // TODO: Delete the book if found, else return HttpStatus.NOT_FOUND; on success, return HttpStatus.NO_CONTENT
    }
}
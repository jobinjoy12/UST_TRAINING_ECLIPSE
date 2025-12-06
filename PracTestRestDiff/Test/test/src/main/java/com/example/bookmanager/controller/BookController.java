package com.example.bookmanager.controller;

import java.net.URI;

import com.example.bookmanager.entity.Book;
import com.example.bookmanager.repository.BookRepository;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    /**
     * Retrieves a paginated and sorted list of books.
     * Example usage: GET /api/books?page=0&size=5&sortBy=title
     *
     * @param page     The page number (0-indexed). Default is 0.
     * @param size     The number of items per page. Default is 10.
     * @param sortBy   The field to sort by (e.g., 'title', 'author', 'id'). Default is 'id'.
     * @return A Page object containing the list of books and pagination information.
     */
    @GetMapping
    public ResponseEntity<Page<Book>> getAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        Sort sort = Sort.by(sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Book> booksPage = bookRepository.findAll(pageable);
        return ResponseEntity.ok(booksPage);
    }
    
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book)
    {
        Book book1 = bookRepository.save(book);

        return ResponseEntity.created(URI.create("/api/books"+book.getId())).body(book1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id , @RequestBody Book book)
    {
        Optional<Book> opt = bookRepository.findById(id);
        if(opt.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        Book book1 = opt.get() ;
        book1.setAuthor(book.getAuthor());
        book1.setTitle(book.getTitle());
        book1.setIsbn(book.getIsbn());

        Book updateBook = bookRepository.save(book1);
        return new ResponseEntity<>(book1,HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id)
    {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        bookRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        
    }
}

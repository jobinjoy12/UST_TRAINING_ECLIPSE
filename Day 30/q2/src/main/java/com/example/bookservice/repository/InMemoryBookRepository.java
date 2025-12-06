package com.example.bookservice.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.example.bookservice.model.Book;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryBookRepository implements BookRepository {

    private final Map<Long, Book> books = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public InMemoryBookRepository() {
        // Initialize with a few sample books
        save(new Book(null, "The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "978-0345391803"));
        save(new Book(null, "1984", "George Orwell", "978-0451524935"));
        save(new Book(null, "To Kill a Mockingbird", "Harper Lee", "978-0061120084"));
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(books.get(id));
    }

    @Override
    public Book save(Book book) {
        if (book.getId() == null) {
            // Assign a new ID if it's a new book
            long id = nextId.getAndIncrement();
            book.setId(id);
        }
        books.put(book.getId(), book);
        return book;
    }

    @Override
    public void deleteById(Long id) {
        books.remove(id);
    }
}
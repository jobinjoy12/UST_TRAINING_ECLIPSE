package com.example.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryBookRepository implements BookRepository {
    private final Map<String, Book> books = new HashMap<>();

    @Override
    public void addBook(Book book) {
        books.put(book.getId(),book);
        // TODO: Implement adding a book to the 'books' map.
    }

    @Override
    public Book findBookById(String id) 
    {
        if(books.containsKey(id))
        {
            return books.get(id);
        }
        // TODO: Implement finding a book by its ID from the 'books' map. Return null if not found.
        return null; // Placeholder return
    }

    @Override
    public List<Book> findAllBooks() {
        
        // TODO: Implement returning a list of all books from the 'books' map.
        return new ArrayList<>(books.values()); // Placeholder return
    }

    @Override
    public void updateBook(Book book) {
        if(books.containsKey(book.getId()))
        {
            books.put(book.getId(),book);
        }
        // TODO: Implement updating an existing book in the 'books' map.
        // The update should identify the book by its ID. If the book with the given ID does not exist, do nothing.
    }

    @Override
    public void deleteBook(String id) {
        if(books.containsKey(id))
        {
            books.remove(id);
        }
        // TODO: Implement deleting a book by its ID from the 'books' map.
    }
}
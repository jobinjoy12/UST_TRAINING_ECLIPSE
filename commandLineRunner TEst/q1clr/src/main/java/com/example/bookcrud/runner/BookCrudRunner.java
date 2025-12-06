package com.example.bookcrud.runner;

import com.example.bookcrud.model.Book;
import com.example.bookcrud.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BookCrudRunner implements CommandLineRunner {

    private final BookRepository bookRepository;

    public BookCrudRunner(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application started! Demonstrating CRUD operations on Book entity:");

        // TODO: Implement the following CRUD operations using bookRepository:
        // 1. Create and save several Book entities.
        // 2. Retrieve all books and print them.
        // 3. Update an existing book's details (e.g., change its title or author).
        // 4. Retrieve a specific book by its ID and print it.
        // 5. Delete a book by its ID.
        // 6. Retrieve all books again to confirm deletion.
        // Print meaningful messages/results at each step to demonstrate success or state.
    }
}

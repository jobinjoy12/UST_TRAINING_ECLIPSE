package com.example.orm.service;

import com.example.orm.model.Author;
import com.example.orm.model.Book;
import com.example.orm.repository.AuthorRepository;
import com.example.orm.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public LibraryService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void createInitialData() {
        System.out.println("--- Creating initial Authors and Books ---");
        // TODO: Implement creating at least two Author entries (e.g., 'Stephen King', 'J.K. Rowling')
        // TODO: Implement creating at least three Book entries, ensuring each book is associated with an existing author.
        // Example: 'The Shining' by Stephen King, 'Harry Potter and the Sorcerer's Stone' by J.K. Rowling, 'It' by Stephen King
        Author author = new Author("Stephen King");
        Author author2 = new Author("J.K. Rowling");

        Book book1 = new Book("The Shining",author);
        Book book2 = new Book("Harry Potter and the Sorcerer's Stone",author);
        Book book3 = new Book("It",author2);

        authorRepository.save(author);
        authorRepository.save(author2);

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        System.out.println("Initial data created.");
    }

    @Transactional(readOnly = true)
    public void readAllAuthors() {
        System.out.println("--- Reading all Authors ---");
        List<Author> list = authorRepository.findAll();
        for(Author a : list)
        {
            System.out.println(a);
        }
        // TODO: Retrieve and print all Author names.
    }

    @Transactional(readOnly = true)
    public void readAllBooksWithAuthors() {
        System.out.println("--- Reading all Books with their Authors ---");
        List<Book> bookL = bookRepository.findAll();
        for(Book b : bookL)
        {
            System.out.println("Title: "+b.getTitle()+" Author: "+b.getAuthor());
        }
        // TODO: Retrieve and print all Book titles along with their respective author names.
    }

    @Transactional(readOnly = true)
    public void readBooksByAuthorName(String authorName) {
        System.out.println("--- Reading all books by " + authorName + " ---");
        List<Book> bookL = bookRepository.findByAuthor(authorName);
        for(Book b: bookL)
        {
            System.out.println("Title: "+b.getTitle());
        }
        // TODO: Retrieve and print all books written by the given author name.
        // You will need a custom query method in BookRepository for this.
    }

    @Transactional(readOnly = true)
    public void readBookByTitle(String title) {
        System.out.println("--- Reading details of the book titled '" + title + "' ---");
        Optional<Book> book = bookRepository.findByTitle(title);
        System.out.println(book);
        // TODO: Retrieve and print the details of the book titled 'The Shining'.
        // You will need a custom query method in BookRepository for this.
    }

    @Transactional
    public void updateBookTitle(String oldTitle, String newTitle) {
        System.out.println("--- Updating book title from '" + oldTitle + "' to '" + newTitle + "' ---");
        // TODO: Find the book by oldTitle and update its title to newTitle.
        // Print the updated book to verify.
        Optional<Book> book1 = bookRepository.findByTitle(oldTitle);
        book1.get().setTitle(newTitle);
        Book book = bookRepository.save(book1.get());
    }

    @Transactional
    public void deleteBookByTitle(String title) {
        System.out.println("--- Deleting book titled '" + title + "' ---");
        Optional<Book> opt = bookRepository.findByTitle(title);
        bookRepository.delete(opt.get());
        Optional<Book> opt2 = bookRepository.findByTitle(title);
        if(opt2.isEmpty())
        {
            System.out.println(title+" has been deleted.");
        }
        // TODO: Delete the book by title from the database.
        // Verify its deletion by attempting to retrieve it or listing all books by its author again.
    }
}
package com.example.bookservice.model;

// TODO: 2. Define the Book Model
// Create a simple Java class named `Book` that represents a book.
// This class should have the following properties:
// - `id` (Long): A unique identifier for the book.
// - `title` (String): The title of the book.
// - `author` (String): The author of the book.
// - `isbn` (String): The International Standard Book Number (ISBN).
// Include a constructor, getters, and setters for all properties.
@Entity
public class Book {

    private Long id;
    private String title ;
    private String author ;
    private String isbn;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public Book(Long id, String title, String author, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public Book(){};
    // TODO: Add id, title, author, isbn fields

    // TODO: Add constructor(s)

    // TODO: Add getters and setters for all properties
}
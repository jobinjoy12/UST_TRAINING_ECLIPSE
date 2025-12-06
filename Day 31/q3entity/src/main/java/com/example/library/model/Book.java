package com.example.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false,length=255)
    private String title;
    @Column(nullable=false,length=13)
    private String isbn;
    @Column(nullable=true)
    private Integer publicationYear;


    public Book(){};

    
    // TODO: Add fields for title (String), isbn (String), and publicationYear (Integer).
    // - title should be non-nullable and have a maximum length of 255 characters.
    // - isbn should be unique and non-nullable, with a fixed length of 13 characters.
    // - publicationYear should be nullable.

    public Book(Long id, String title, String isbn, Integer publicationYear, Author author) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.author = author;
    }


    // TODO: Establish a many-to-one relationship from Book to Author.
    // The foreign key column in the Book table should be named 'author_id' and be non-nullable.
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;


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


    public String getIsbn() {
        return isbn;
    }


    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public Integer getPublicationYear() {
        return publicationYear;
    }


    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }


    public Author getAuthor() {
        return author;
    }


    public void setAuthor(Author author) {
        this.author = author;
    }

    // TODO: Include a default constructor.
    // TODO: Include getters and setters for all fields.
}
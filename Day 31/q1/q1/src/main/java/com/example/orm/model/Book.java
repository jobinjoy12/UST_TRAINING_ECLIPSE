package com.example.orm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn
    public Author author;
    // TODO: Define the many-to-one relationship with Author here
    // A Book belongs to one Author.
    // Use @JoinColumn to specify the foreign key column.
    // private Author author;

    public Book() {
    }

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
        // TODO: Assign the author to the relationship field here
    }

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

    
    // TODO: Add getter and setter for the 'author' relationship field

    

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
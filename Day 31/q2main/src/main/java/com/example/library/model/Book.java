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

    // TODO: Add fields for title (String), isbn (String), and publicationYear (Integer).
    // - title should be non-nullable and have a maximum length of 255 characters.
    // - isbn should be unique and non-nullable, with a fixed length of 13 characters.
    // - publicationYear should be nullable.

    // TODO: Establish a many-to-one relationship from Book to Author.
    // The foreign key column in the Book table should be named 'author_id' and be non-nullable.
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    // TODO: Include a default constructor.
    // TODO: Include getters and setters for all fields.
}
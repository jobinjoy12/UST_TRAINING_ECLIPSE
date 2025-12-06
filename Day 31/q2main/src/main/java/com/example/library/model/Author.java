package com.example.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO: Add fields for firstName (String) and lastName (String).
    // Ensure both are non-nullable and have a maximum length of 100 characters.

    // TODO: Include a default constructor.
    // TODO: Include getters and setters for all fields.
}
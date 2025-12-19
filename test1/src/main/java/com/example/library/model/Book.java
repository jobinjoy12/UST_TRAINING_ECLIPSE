package com.example.library.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String isbn;

    public Book(String title , String isbn){
        this.title = title; 
        this.isbn = isbn ; 
    }

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "author_id")
    Author author;
}

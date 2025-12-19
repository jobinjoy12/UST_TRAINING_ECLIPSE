package com.example.library.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "author" , cascade = CascadeType.ALL , orphanRemoval = true)
    @JsonManagedReference
    List<Book> books = new ArrayList<>();

    public Author(String name){
        this.name = name ;
    }
}

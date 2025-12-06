package com.example.orm.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy="author")
    public Set<Book> books = new HashSet<>();
    // TODO: Define the one-to-many relationship with Book here
    // An Author can have many Books.
    // Use 'mappedBy' to indicate the owning side of the relationship is in the Book entity.
    // Initialize the set to avoid NullPointerExceptions.
    // private Set<Book> books = new HashSet<>();

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // TODO: Add getter and setter for the 'books' collection

    @Override
    public String toString() {
        return "Author{" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
    }
}
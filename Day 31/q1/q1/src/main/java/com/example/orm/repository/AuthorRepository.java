package com.example.orm.repository;

import com.example.orm.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    // Spring Data JPA automatically provides basic CRUD operations.
    // Custom query methods can be defined here if needed, following Spring Data JPA naming conventions.
}
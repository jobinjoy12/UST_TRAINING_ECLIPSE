package com.example.productmanagement.repository;

import com.example.productmanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// TODO: Make this interface extend JpaRepository to provide CRUD operations for the Product entity.
// It should be parameterized with the Product entity and its ID type (Long).

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // JpaRepository provides basic CRUD methods out of the box.
    // No need to add methods here for basic operations.
}

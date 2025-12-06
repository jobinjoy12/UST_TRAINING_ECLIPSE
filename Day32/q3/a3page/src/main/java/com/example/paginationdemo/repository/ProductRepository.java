package com.example.paginationdemo.repository;

import com.example.paginationdemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // JpaRepository provides methods for pagination and sorting automatically.
    // No custom methods are needed here for this task.
}

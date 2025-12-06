package com.example.product.repository;

import com.example.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// TODO: Create a Java interface named ProductRepository.
// TODO: This interface must extend JpaRepository, specifying Product as the entity type and Long as the ID type.
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

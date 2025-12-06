package com.example.rest.demo.service;

import com.example.rest.demo.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAllProducts();
    Optional<Product> findProductById(Long id);
    Product saveProduct(Product product);
    Optional<Product> updateProduct(Long id, Product productDetails);
    boolean deleteProduct(Long id);
}
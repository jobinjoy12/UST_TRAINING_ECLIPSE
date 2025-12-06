package com.example.rest.demo.controller;

import com.example.rest.demo.entity.Product;
import com.example.rest.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        // TODO: Implement logic to retrieve all products using ProductService and return them with an appropriate HTTP status.
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        // TODO: Implement logic to retrieve a product by its ID using ProductService. Return the product if found, or a 404 Not Found if not.
        return null;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        // TODO: Implement logic to save a new product using ProductService. Return the saved product with a 201 Created status.
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        // TODO: Implement logic to update an existing product by ID using ProductService. Return the updated product if found, or a 404 Not Found if not.
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable Long id) {
        // TODO: Implement logic to delete a product by its ID using ProductService. Return a 204 No Content status on successful deletion, or 404 if not found.
        return null;
    }
}
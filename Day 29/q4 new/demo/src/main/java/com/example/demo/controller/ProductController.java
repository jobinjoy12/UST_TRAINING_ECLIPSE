package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        // TODO: Implement a GET endpoint to retrieve all products.
        // Call the appropriate service method and return the list of products with an OK status.
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        // TODO: Implement a GET endpoint to retrieve a product by its ID.
        // Call the appropriate service method. If the product is found, return it with an OK status.
        // If not found, return a NOT_FOUND status.
        Optional<Product> product = productService.getProductById(id);
        return product.map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        // TODO: Implement a POST endpoint to add a new product.
        // Call the appropriate service method and return the created product with a CREATED status.
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        // TODO: Implement a PUT endpoint to update an existing product by its ID.
        // Call the appropriate service method. If the product is updated, return the updated product with an OK status.
        // If the product with the given ID is not found, return a NOT_FOUND status.
        Optional<Product> updated = productService.updateProduct(id, product);
        return updated.map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        // TODO: Implement a DELETE endpoint to delete a product by its ID.
        // Call the appropriate service method. If the product is deleted, return a NO_CONTENT status.
        // If the product with the given ID is not found (or deletion fails), return a NOT_FOUND status.
        boolean deleted = productService.deleteProduct(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

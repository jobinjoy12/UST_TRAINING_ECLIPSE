package com.example.rest.demo.controller;

import com.example.rest.demo.entity.Product;
import com.example.rest.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> list = productService.findAllProducts();
        if(list.isEmpty()){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
        // TODO: Implement logic to retrieve all products using ProductService and return them with an appropriate HTTP status.
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> prod = productService.findProductById(id);
        if(prod.isPresent()){
           return ResponseEntity.ok(prod.get());
        }
        // TODO: Implement logic to retrieve a product by its ID using ProductService. Return the product if found, or a 404 Not Found if not.
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product pro = productService.saveProduct(product);
        if(pro == null){
            return ResponseEntity.noContent().build();
        }
        // TODO: Implement logic to save a new product using ProductService. Return the saved product with a 201 Created status.
        return ResponseEntity.ok(pro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        // TODO: Implement logic to update an existing product by ID using ProductService. Return the updated product if found, or a 404 Not Found if not.
        Optional<Product> pro = productService.updateProduct(id, productDetails);
        if(pro.isPresent())
        {
        return ResponseEntity.ok(pro.get());
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable Long id) {
        Boolean b = productService.deleteProduct(id);
        if(b == true){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
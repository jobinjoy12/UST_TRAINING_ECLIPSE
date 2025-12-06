package com.example.paginationdemo.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.paginationdemo.model.Product;
import com.example.paginationdemo.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Page<Product>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "ASC") String sortDirection) {



        // TODO: Call the productService to get the paginated and sorted list of products
        Page<Product> products = productService.getAllProducts(page, size, sortBy, sortDirection); // Replace null with the actual service call

        // TODO: Return the Page<Product> in a ResponseEntity
        return ResponseEntity.ok(products); // Replace null with the actual ResponseEntity
    }
}

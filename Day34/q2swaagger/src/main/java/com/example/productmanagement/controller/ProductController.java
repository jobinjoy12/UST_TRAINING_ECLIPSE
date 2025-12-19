package com.example.productmanagement.controller;

import com.example.productmanagement.model.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Tag(name = "Products", description = "Operations pertaining to product management")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final List<Product> products = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public ProductController() {
        products.add(new Product(counter.incrementAndGet(), "Laptop", 1200.00));
        products.add(new Product(counter.incrementAndGet(), "Mouse", 25.00));
        products.add(new Product(counter.incrementAndGet(), "Keyboard", 75.00));
    }

    @Operation(summary = "Retrieve all products", description = "Returns a list of all available products")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of products",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)))
    @GetMapping
    public List<Product> getAllProducts() {
        return products;
    }

    @Operation(summary = "Retrieve a product by ID", description = "Returns a single product based on its ID")
    @ApiResponse(responseCode = "200", description = "Product found",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)))
    @ApiResponse(responseCode = "404", description = "Product not found")
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(
            @Parameter(description = "ID of the product to retrieve", required = true) @PathVariable Long id) {
        Optional<Product> product = products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

        return product.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new product", description = "Creates a new product and returns the created product with its assigned ID")
    @ApiResponse(responseCode = "201", description = "Product created successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)))
    @ApiResponse(responseCode = "400", description = "Invalid product details provided")
    @PostMapping
    public ResponseEntity<Product> createProduct(
            @RequestBody(description = "Product object to be created", required = true,
                    content = @Content(schema = @Schema(implementation = Product.class)))
            @org.springframework.web.bind.annotation.RequestBody Product product) {

        if (product.getName() == null || product.getName().isBlank() || product.getPrice() <= 0) {
            return ResponseEntity.badRequest().build();
        }

        product.setId(counter.incrementAndGet());
        products.add(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @Operation(summary = "Update an existing product", description = "Updates the details of an existing product based on its ID")
    @ApiResponse(responseCode = "200", description = "Product updated successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)))
    @ApiResponse(responseCode = "400", description = "Invalid product details provided")
    @ApiResponse(responseCode = "404", description = "Product not found")
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @Parameter(description = "ID of the product to update", required = true) @PathVariable Long id,
            @RequestBody(description = "Updated product object", required = true,
                    content = @Content(schema = @Schema(implementation = Product.class)))
            @org.springframework.web.bind.annotation.RequestBody Product updatedProduct) {

        if (updatedProduct.getName() == null || updatedProduct.getName().isBlank() || updatedProduct.getPrice() <= 0) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Product> existingProduct = products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

        if (existingProduct.isPresent()) {
            Product p = existingProduct.get();
            p.setName(updatedProduct.getName());
            p.setPrice(updatedProduct.getPrice());
            return ResponseEntity.ok(p);
        }

        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Delete a product by ID", description = "Deletes a product from the system")
    @ApiResponse(responseCode = "204", description = "Product deleted successfully")
    @ApiResponse(responseCode = "404", description = "Product not found")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(
            @Parameter(description = "ID of the product to delete", required = true) @PathVariable Long id) {

        boolean removed = products.removeIf(p -> p.getId().equals(id));

        if (removed) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
package com.example.productcatalog.controller;

import com.example.productcatalog.model.Product;
import com.example.productcatalog.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/browse")
    public ResponseEntity<List<Product>> filterProductsByCategory(@RequestParam String category) {
        List<Product> products = productService.filterProductsByCategory(category);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/sortPriceDesc")
    public ResponseEntity<List<Product>> sortProductsByPriceDesc() {
        List<Product> products = productService.sortProductsByPriceDesc();
        return ResponseEntity.ok(products);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> patchProduct(@PathVariable int id, @RequestBody Product productDetails) {
        Product updatedProduct = productService.patchProduct(id, productDetails);
        return ResponseEntity.ok(updatedProduct);
    }

    @GetMapping("/total")
    public ResponseEntity<Map<String, Integer>> getTotalProducts() {
        int total = productService.getTotalProducts();
        return ResponseEntity.ok(Map.of("totalProducts", total));
    }

    @DeleteMapping("/clearAll")
    public ResponseEntity<Void> clearAllProducts() {
        productService.clearAllProducts();
        return ResponseEntity.noContent().build();
    }
}
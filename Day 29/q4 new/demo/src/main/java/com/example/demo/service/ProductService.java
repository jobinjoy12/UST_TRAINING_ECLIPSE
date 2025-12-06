package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public ProductService() {
        // Initialize with some dummy data
        products.add(new Product(counter.incrementAndGet(), "Laptop", 1200.00));
        products.add(new Product(counter.incrementAndGet(), "Mouse", 25.00));
        products.add(new Product(counter.incrementAndGet(), "Keyboard", 75.00));
    }

    public List<Product> getAllProducts() {
        // TODO: Implement logic to return all products from the 'products' list.
        return products;
    }

    public Optional<Product> getProductById(Long id) {
        // TODO: Implement logic to find and return a product by its ID from the 'products' list.
        // If no product is found, return Optional.empty().
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public Product addProduct(Product product) {
        // TODO: Implement logic to add a new product to the 'products' list.
        // Assign a new unique ID to the product before adding it.
        product.setId(counter.incrementAndGet());
        products.add(product);
        return product;
    }

    public Optional<Product> updateProduct(Long id, Product updatedProduct) {
        // TODO: Implement logic to update an existing product in the 'products' list.
        // Find the product by ID, update its name and price, and return the updated product.
        // If the product with the given ID is not found, return Optional.empty().
        return getProductById(id).map(existingProduct -> {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            return existingProduct;
        });
    }

    public boolean deleteProduct(Long id) {
        // TODO: Implement logic to delete a product from the 'products' list by its ID.
        // Return true if the product was successfully deleted, false otherwise.
        return products.removeIf(product -> product.getId().equals(id));
    }
}

package com.example.paginationdemo;

import com.example.paginationdemo.model.Product;
import com.example.paginationdemo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    public DataLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null, "Laptop", 1200.00, "Electronics"));
        productRepository.save(new Product(null, "Mouse", 25.00, "Electronics"));
        productRepository.save(new Product(null, "Keyboard", 75.00, "Electronics"));
        productRepository.save(new Product(null, "Monitor", 300.00, "Electronics"));
        productRepository.save(new Product(null, "Desk Chair", 150.00, "Furniture"));
        productRepository.save(new Product(null, "Coffee Table", 90.00, "Furniture"));
        productRepository.save(new Product(null, "Book Shelf", 110.00, "Furniture"));
        productRepository.save(new Product(null, "Smartphone", 800.00, "Electronics"));
        productRepository.save(new Product(null, "Headphones", 100.00, "Electronics"));
        productRepository.save(new Product(null, "Webcam", 50.00, "Electronics"));
        productRepository.save(new Product(null, "Router", 80.00, "Networking"));
        productRepository.save(new Product(null, "External SSD", 180.00, "Storage"));
        productRepository.save(new Product(null, "Graphics Card", 500.00, "Components"));
        productRepository.save(new Product(null, "Printer", 120.00, "Peripherals"));
    }
}

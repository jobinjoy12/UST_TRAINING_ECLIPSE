package com.example.inventory.service;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.inventory.entity.Product;
import com.example.inventory.repository.ProductRepository;

@Component
public class InventoryRunner implements CommandLineRunner {

    private final ProductRepository productRepository;

    // Constructor-based dependency injection
    public InventoryRunner(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n--- Inventory Management Operations --- ");
        
        Product p1 = new Product("Pen",10.0,1);
        Product p2 = new Product("Pencil",9.0,2);

        System.out.println("Created 2 products");

        productRepository.save(p1);
        productRepository.save(p2);

        System.out.println("Saved 2 products");

        List<Product> proL = productRepository.findAll();
        System.out.println("Products : "+proL);

        String name = "Eraser";
        p1.setName(name);
        productRepository.save(p1);
            System.out.println("Update product: "+p1);

        productRepository.delete(p2);
        System.out.println("Deleted Product");
        // TODO: Implement the following inventory management operations:
        // 1. Create and save new product entries.
        // 2. Retrieve all products currently in the inventory.
        // 3. Update an existing product's details.
        // 4. Delete a product from the inventory.
        // 5. Print clear and meaningful messages at each stage of the process.
        
        System.out.println("--- Inventory Management Operations Completed --- ");
    }
}
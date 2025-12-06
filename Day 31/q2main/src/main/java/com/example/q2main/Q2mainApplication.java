package com.example.q2main;

import java.util.Optional;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Q2mainApplication {

    public static void main(String[] args) {
        SpringApplication.run(Q2mainApplication.class, args);
    }

    @Bean
    public CommandLineRunner load(ProductRepository productRepository) {
        return args -> {
            Product product1 = new Product("Laptop", 1200.00, "High-performance laptop");
            Product product2 = new Product("Smartphone", 800.00, "Latest Android smartphone");
            Product product3 = new Product("Headphones", 150.00, "Noise-cancelling headphones");

            productRepository.save(product1);
            productRepository.save(product2);
            productRepository.save(product3);

			System.out.println(productRepository.findAll());

			System.out.println(productRepository.findById(product1.getId()));

			Optional<Product> p1 = productRepository.findById(product1.getId());

			if(p1.isPresent())
			{
				p1.get().setPrice(1200.0);
				p1.get().setDescription("This can be used for hearing");

				productRepository.save(p1.get());
			}

			productRepository.deleteById(product2.getId());

			Optional<Product> opt2 =  productRepository.findById(product2.getId());
			
			if(op2.isEmpty())
			{
				System.out.println("Deleted");
			}
		
		};


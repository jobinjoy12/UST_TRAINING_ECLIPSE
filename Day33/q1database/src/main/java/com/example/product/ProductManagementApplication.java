package com.example.product;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductRepository productRepository)
	{
		return (String...args)-> {
			Product product1 = new Product("Laptop","Powerful Laptop",1200.00);
			productRepository.save(product1);

			Product pro2 = new Product("Mobile" , "IPhone",1500.00);
			productRepository.save(pro2);

			System.out.println("Products found with finalAll():");
			productRepository.findAll().forEach(s->System.out.println(s));

			productRepository.findById(1L).ifPresent(p-> System.out.println(p));
		};

		

	}
	// @Bean
	// public CommandLineRunner demo(ProductRepository productRepository) {
	// 	return (args) -> {
	// 		// TODO: Create and save at least two new Product entities to the database.
	// 		// Example: Product product1 = new Product(null, "Laptop", "Powerful laptop", 1200.00);
	// 		//          productRepository.save(product1);
			

	// 		// TODO: Retrieve all products from the database and print them to the console.
	// 		// Example: System.out.println("Products found with findAll():");
	// 		//          productRepository.findAll().forEach(System.out::println);


	// 		// TODO: Retrieve one specific product by its ID and print it to the console.
	// 		// Example: productRepository.findById(1L)
	// 		//                      .ifPresent(product -> System.out.println("Product found by ID 1:" + product));
	// 	};
	// }
}

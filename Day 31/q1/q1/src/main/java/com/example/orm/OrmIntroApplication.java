package com.example.orm;

import com.example.orm.service.LibraryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrmIntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrmIntroApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(LibraryService libraryService) {
		return args -> {
			System.out.println("\n--- Starting ORM Hands-on Task ---");

			// TODO: Call methods from LibraryService to perform CRUD operations
			// Follow the task steps:
			// 1. Create Authors and Books
			// 2. Read operations (all authors, all books with authors, books by Stephen King, book by title)
			// 3. Update a book's title
			// 4. Delete a book and verify

			// Example: Calling the method to create initial data
			libraryService.createInitialData();

			// TODO: Implement the rest of the CRUD operations by calling methods from libraryService
			System.out.println("\n--- ORM Hands-on Task Completed ---");
		};
	}
}
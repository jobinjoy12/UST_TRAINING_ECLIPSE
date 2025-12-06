package com.example.q232;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner clr(BookRepository bookRepository,AuthorRepository authorRepository){
    return args -> {

        Author author1 = new Author(null, "George Orwell");
            Author author2 = new Author(null, "J.K. Rowling");
            Author author3 = new Author(null, "Yuval Noah Harari");

            authorRepository.saveAll(List.of(author1, author2, author3));

            // Create Books
            Book book1 = new Book( "1984", "Dystopian", 500.0,1948, author1);
            Book book2 = new Book("Animal Farm", "Satire",300.0,1945 ,author1);
            Book book3 = new Book( "Harry Potter", "Fantasy",800.0,1997, author2);
            Book book4 = new Book("Sapiens", "History",1000.0,2011,author3);

            bookRepository.saveAll(List.of(book1, book2, book3, book4));

            System.out.println("\n--- Books containing 'Harry' ---");
            bookRepository.findBooksByTitleContaining("Harry")
                    .forEach(System.out::println);

            System.out.println("\n--- Titles and Authors by Genre 'Fantasy' ---");
            bookRepository.findBookTitlesAndAuthorsByGenre("Fantasy")
                    .forEach(result -> System.out.println("Title: " + result[0] + ", Author: " + result[1]));

            System.out.println("\n--- Count of books published after 1950 ---");
            System.out.println(bookRepository.countBooksPublishedAfter(1950));

            
            System.out.println("\n--- Update Book Price ---");
            bookRepository.updateBookPrice(book1.getId(), 600.0);
            System.out.println("Updated Book: " + bookRepository.findById(book1.getId()).get());

            System.out.println("\n--- All Books (Native) ---");
            bookRepository.findAllBooksNative().forEach(System.out::println);

            System.out.println("\n--- Books Above Average Price (Native) ---");
            bookRepository.findBooksAboveAveragePriceNative().forEach(System.out::println);

            System.out.println("\n--- Top 2 Most Expensive Books (Native) ---");
            bookRepository.findTopNMostExpensiveBooksNative(2).forEach(System.out::println);
        };


    };
}


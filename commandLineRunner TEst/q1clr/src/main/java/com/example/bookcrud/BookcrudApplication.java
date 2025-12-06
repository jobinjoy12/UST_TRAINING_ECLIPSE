package com.example.bookcrud;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookcrud.model.Book;
import com.example.bookcrud.repository.BookRepository;

@SpringBootApplication
public class BookcrudApplication {

	public BookRepository bookRepository;

	public BookcrudApplication(BookRepository bookRepository)
	{
		this.bookRepository = bookRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookcrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner clr(){
		return(args)->{
			Book book1 = new Book("HarryPotter","Jobin","8901");
			Book book2 = new Book("Niranj","Kavuz","90921");
			System.out.println("create 2 books");
			bookRepository.save(book1);
			bookRepository.save(book2);
			System.out.println("saved books");
			
			List<Book> bookList = bookRepository.findAll();
			System.out.println("Books : "+bookList);

			String title = "JobinBook";
			book1.setTitle(title);
			bookRepository.save(book1);
			System.out.println("updated book"+book1);

			Long id1 = book1.getId();
			Optional<Book> bookopt = bookRepository.findById(id1);
			Book book = bookopt.get();
			System.out.println("Found book"+book);
			bookRepository.delete(book1);


			System.out.println("Deleted book");

			
		};
	}

}

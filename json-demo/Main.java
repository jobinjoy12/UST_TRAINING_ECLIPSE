package com.example.json_demo;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

class Book{
	private String title;
	private String author;
	private int publicationYear;
	private String isbn;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Book(String title, String author, int publicationYear, String isbn) {
		super();
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
	}
	
	public Book() {}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", publicationYear=" + publicationYear + ", isbn=" + isbn
				+ "]";
	};
	
	
	
}


public class Main
{
	public static void main(String[] args) throws Exception {
		String jsonBooksJackson = """
				[
				  {
				    "title": "The Hitchhiker's Guide to the Galaxy",
				    "author": "Douglas Adams",
				    "publicationYear": 1979,
				    "isbn": "978-0345391803"
				  },
				  {
				    "title": "Pride and Prejudice",
				    "author": "Jane Austen",
				    "publicationYear": 1813,
				    "isbn": "978-0141439518"
				  }
				]
				""";
		ObjectMapper mapper = new ObjectMapper();
		List<Book> books = mapper.readValue(jsonBooksJackson, new TypeReference<List<Book>>() {} );
	
		for(Book b:books)
		{
			System.out.println("Title: "+b.getTitle()+" Author "+b.getAuthor());
		}
		
		String jsonBookGson = """
				{
				  "title": "1984",
				  "author": "George Orwell",
				  "publicationYear": 1949,
				  "isbn": "978-0451524935"
				}
				
				""";
		Book book = new Book();
		Gson gson = new Gson();
		book = gson.fromJson(jsonBookGson,Book.class);
		System.out.println("Title: "+book.getTitle()+" Author: "+book.getAuthor()+" PublicationYear: "+book.getPublicationYear());
		
		Book newBook = new Book("The Hobbit", "J.R.R. Tolkien", 1937, "978-0345339683");
		String jsonString = mapper.writeValueAsString(newBook);
		System.out.println(jsonString);//printing jsonString
		String GsonString = gson.toJson(newBook);
		System.out.println(GsonString);
	}
}


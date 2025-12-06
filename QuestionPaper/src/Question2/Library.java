package Question2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Book {
	private String isbn;
	private String title;
	private String author;

	public Book(String isbn, String title, String author) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(isbn, other.isbn);
				
	}
	
	}

public class Library {
	private Set<Book> books;

	public Library() {
		books = new HashSet<>();
	}

	public boolean addBook(Book book) {
		if(books.add(book)) {
			return true;
		}
		return false;
	}

	public boolean removeBook(String isbn) {
		// Your code her
		Book bok = findBookByISBN(isbn);
		return books.remove(bok);
	}

	public Book findBookByISBN(String isbn) {
		// Your code here
		
		for(Book book:books)
		{
			if(book.getIsbn().equals(isbn)) {
				return book;
			}
		}return null;
	}

	public int getTotalBooks() {
		// Your code here
		return books.size();
	}
}
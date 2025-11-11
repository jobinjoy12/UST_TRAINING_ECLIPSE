package com.library.app;
import com.library.model.*;
import com.library.service.*;

public class Main {
	public static void main(String[] args) {
		Library lib1 = new Library();
		Book book1 = new Book("Harry Potter","Jobin","12345");
		Book book2 = new Book("Justice League","Gokul","93132");
		Book book3 = new Book("Marvel","Stephen","12842");
		lib1.addBook(book1);
		lib1.addBook(book2);
		lib1.addBook(book3);
		lib1.displayAllBook();
	}
}


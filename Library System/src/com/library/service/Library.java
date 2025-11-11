package com.library.service;
import com.library.model.*;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Book> lst = new ArrayList<Book>();
	
	public void addBook(Book book){
		lst.add(book);
	}
	
	public void displayAllBook() {
		for(Book book : lst)
		System.out.println(book);
	}
}

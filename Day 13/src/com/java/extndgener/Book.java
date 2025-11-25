package com.java.extndgener;
import java.util.List;
import java.util.ArrayList;

public class Book implements Comparable<Book> {
	public String title;
	public int publicationYear ;
	
	public Book(String title , int publicationYear)
	{
		this.title = title;
		this.publicationYear = publicationYear;
	}
	
	public int compareTo(Book o) {
		if(this.publicationYear == o.publicationYear)
			return 0;
		if(this.publicationYear > o.publicationYear)
		{
			return -1;
		}
		return 1;
	}
	
	public static void main(String[] args)
	{
		List<Book> list = new ArrayList<>();
		Book o1 = new Book("Harry Potter" , 1990);
		Book o2 = new Book("Alwin",2000);
		list.add(o2);
		list.add(o1);
		System.out.println(CollectionUtilites.findMax(list));
	}
}

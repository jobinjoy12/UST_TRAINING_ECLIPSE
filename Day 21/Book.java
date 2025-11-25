// Solution for Learner Hands-on Task: Making Classes Serializable

import java.io.Serializable;

public class Book implements Serializable{
    private String title;
    private String author ;
    private double price;
    private String isbn;

    @Override
    public String toString() {
        return "Book: " + title + "by " + author + ", Price: " + price + ", ISBN: " + isbn ;
    }

    public Book(String title , String author,  double price, String isbn)
    {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public String getIsbn() {
        return isbn;
    }
    
}
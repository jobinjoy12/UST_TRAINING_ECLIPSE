class Book {
	private String title;
	private String author;
	private int publicationYear;
	
	public Book(String title , String author , int publicationYear) {
		this.title = title;
		this.author = author ;
		this.publicationYear = publicationYear;
	}
	public void displayBookInfo(){
		System.out.println("Title: "+title+", Author: "+author+", Year: "+publicationYear);
	}
}
public class Main{
	public static void main(String[] args) {
		Book obj1 = new Book("Book1","Jane Austen",1813);
        Book obj2 = new Book("Java Basics", "George Orwell", 1949);
        Book obj3 = new Book("Harry Potter","J.K. Rowling",1997);
        obj1.displayBookInfo();
        obj2.displayBookInfo();
        obj3.displayBookInfo();
	}
}


class Book  {
		private String title;
		private String author;
		private int publicationYear;
		public Book(String title , String author, int year){
			this.title = title ; 
			this.author = author;
			this.publicationYear = year;
		}
		public void displayBookInfo(){
			System.out.println(title + " , "+ author + " " + publicationYear);
		}
		public int getPublicationYear(){
			return publicationYear;
		}
	}
public class Book1{
	public static void main(String[] args) {
		Book obj1 = new Book("Lion","Jobin",1990);
		Book obj2 = new Book("Simham","Surya",1998);
		Book obj3 = new Book("Cherup","King",2000);
		obj1.displayBookInfo();
		obj2.displayBookInfo();
		obj3.displayBookInfo();
		System.out.println(obj1.getPublicationYear());
		System.out.println(obj2.getPublicationYear());
		System.out.println(obj3.getPublicationYear());
	}
}

class Product {
		private String productId;
		private String productName;
		private double price;
		public Product(String id , String name , double price) {
			this.productId = id;
			this.productName = name ;
			this.price = price ;
			System.out.println("Product "+name+" (ID: "+id+") has been created");
		}
		public void displayProductDetails() {
			System.out.println(productId + " " + productName + " " + price );
		}
		}
public class Main{
	public static void main(String[] args) {
		Product laptop = new Product("P101", "Laptop", 1200.00);
		Product mouse = new Product("P102", "Wireless Mouse", 25.50);
		Product keyboard = new Product("P103", "Mechanical Keyboard", 80.00);
		laptop.displayProductDetails();
		mouse.displayProductDetails();
		keyboard.displayProductDetails();
		laptop = null;
		System.out.println("Laptop reference set to null.");
		laptop.displayProductDetails();
	}
}
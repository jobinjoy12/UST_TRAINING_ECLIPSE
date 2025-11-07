
class Product {
		private String productId;
		private String productName;
		private double price;
		private boolean inStock;
		public Product() {
			productId = "N/A";
			productName = "Unknown Product";
			price = 0.0;
			inStock = false;
					
		}
		public Product(String id , String name , double price,  boolean inStock) {
			this.productId = id;
			this.productName = name ;
			this.price = price ;
			this.inStock = inStock ;
		}
		public Product(String id , String name , double price) {
			this.productId = id;
			this.productName = name ;
			this.price = price ;
			inStock = true;
		}
		public void displayProductDetails() {
			System.out.println(productId + " " + productName + " " + price + " " + inStock);
		}
		}
public class Main{
	public static void main(String[] args) {
		Product obj1 = new Product();
		Product obj2 = new Product("JJ","Jobin",90.0,true);
		Product obj3 = new Product("NJ","Ninja",100.0);
		obj1.displayProductDetails();
		obj2.displayProductDetails();
		obj3.displayProductDetails();
		
	}
}
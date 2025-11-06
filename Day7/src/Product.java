
public class Product {
	private String name ;
	private double price ;
	private String productId;
	
	public Product(String name, double price, String productId) {
		this.name = name ;
		this.price = price ;
		this.productId = productId;
	}
//	`public String getName()`: Returns the name of the product.
//	* `public double getPrice()`: Returns the price of the product.
//	* `public void setPrice(double newPrice)`: Sets a new price for the product. This method should throw an `IllegalArgumentException` if `newPrice` is negative.
//	* `public String getProductId()`: Returns the unique product ID.
//	* `public double calculateDiscount(double percentage)`: Calculates and returns the discounted price based on the given percentage. This method should throw an `IllegalArgumentException` if `percentage` is not between 0 and 100.
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price ;
	}
	public void setPrice(double newPrice) {
		price = newPrice ;
	}
	public String getProductId() {
		return productId;
	}
	public double calculateDiscount(double percentage) {
		
	}
}

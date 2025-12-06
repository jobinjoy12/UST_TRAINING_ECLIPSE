package Question2;

public class Product {
	private String id;
	private String name;
	private double price;

	public Product(String id, String name, double price) {
		this.id = id;
		this.name=  name;
		this.price = price;
	}

	public String getId() {
		// Your code here
		return id;
	}

	public String getName() {
		// Your code here
		return name;
	}

	public void setName(String name) {
		// Your code here
		this.name = name ;
	}

	public double getPrice() {
		// Your code here
		return price;
	}

	public void setPrice(double price) {
		// Your code here
		this.price = price;
	}
}
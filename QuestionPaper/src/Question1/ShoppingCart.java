package Question1;

import java.util.ArrayList;
import java.util.Objects;

abstract class Product {
	protected String name;
	protected double price;

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public abstract double getPrice();

	@Override
	public boolean equals(Object o) {
		if(this==o)
			return true;
		if(o == null || o.getClass()!= this.getClass()) {
			return false;
		}
		Product product =  (Product) o;
		return Objects.equals(this.name, product.name);
			
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	
}

class Book extends Product {
	public Book(String name, double price) {
		super(name, price);
	}

	@Override
	public double getPrice() {
		return price;
	}
}

class Electronics extends Product {
	public Electronics(String name, double price) {
		super(name, price);
	}

	@Override
	public double getPrice() {
		return price;
	}
}

class ShoppingCart {
	private ArrayList<Product> items;

	public ShoppingCart() {
		this.items = new ArrayList<>();
	}

	public void addProduct(Product product) {
		// Your code here
		items.add(product);
	}

	public boolean removeProduct(Product product) {
		// Your code here: Use the overridden equals() method
		return items.remove(product);
	}

	public double getTotalPrice() {
		// Your code here
		double total = 0.0;
		for (Product item : items) {
			total += item.getPrice();
		}
		return total;
	}
}

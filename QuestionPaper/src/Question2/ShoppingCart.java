package Question2;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

class Item {
	private String name;
	private double price;

	public Item(String name, double price) {
		// Your code here
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o)
		return true;
		if(o==null || this.getClass()!=o.getClass())
			return false;
		Item item = (Item) o;
		return Objects.equals(this.name ,item.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.name);
	}
}

public class ShoppingCart {
	private Set<Item> items;

	public ShoppingCart() {
		items = new HashSet<>();
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public int getItemCount() {
		return items.size();
	}
}
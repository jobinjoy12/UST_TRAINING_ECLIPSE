package Question3;

import java.util.ArrayList;
import java.util.List;

class Item {
	private String itemId;
	private String name;
	private int stockLevel;

	public Item(String itemId, String name, int stockLevel) {
		this.itemId = itemId;
		this.name = name;
		this.stockLevel = stockLevel;
	}

	public String getItemId() {
		return itemId;
	}

	public String getName() {
		return name;
	}

	public int getStockLevel() {
		return stockLevel;
	}

	public void setStockLevel(int stockLevel) {
		if (stockLevel >= 0) {
			this.stockLevel = stockLevel;
		}
	}

	@Override
	public String toString() {
		return "Item ID: " + itemId + ", Name: " + name + ", Stock: " + stockLevel;
	}
}

public class Warehouse {
	private List<Item> items;

	public Warehouse() {
		this.items = new ArrayList<>();
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public void updateStock(String itemId, int quantityChange) {
		Item item = findItem(itemId);
		if (item != null) {
			int newStock = item.getStockLevel() + quantityChange;
			item.setStockLevel(newStock);
		}
	}

	public void displayAllItems() {
		for (Item item : items) {
			System.out.println(item);
		}
	}

	public Item findItem(String itemId) {
		for (Item item : items) {
			if (item.getItemId().equals(itemId)) {
				return item;
			}
		}
		return null;
	}
}
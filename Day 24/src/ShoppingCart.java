import java.util.List;

public class ShoppingCart {
	private List<String> list;
	private double totalPrice;
	
	public ShoppingCart()
	{
		this.list = null;
		this.totalPrice = 0.0;
	}
	
	public void addItem(String itemName ,double price)
	{
		list.add(itemName);
		totalPrice += price;
	}
	public void removeItem(String itemName ,  double price)
	{
		if(list.contains(itemName))
		{
			list.remove(itemName);
		}
		totalPrice -= price;
	}
	
	public int getItemCount()
	{
		return list.size();
	}
	
	public double getTotalPrice()
	{
		return totalPrice;
	}
	
}

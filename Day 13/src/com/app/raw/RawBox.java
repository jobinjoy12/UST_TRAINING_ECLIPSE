	package com.app.raw;

public class RawBox {
	private Object item;//initializes private item of type Object.
	
	public RawBox(Object item)//constructor
	{
		this.item = item;
	}
	
	public Object getItem()//getter method
	{
		return item;
	}
	
	public static void main(String[] args)//Main method
	{
		RawBox o1 = new RawBox(123);
		RawBox o2 = new RawBox("Hello String");
		int item = (int)o1.getItem();
		System.out.println(item);
		int item2 = (int)o2.getItem();
	}
}

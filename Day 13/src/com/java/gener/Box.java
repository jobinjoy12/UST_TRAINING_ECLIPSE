package com.java.gener;

public class Box <T> {//Creates a new class named box with type parameter
	private T content;
	public Box(T content)
	{
		this.content = content;
	}
	public T getItem()
	{
		return content;
	}
	public void setItem(T item)
	{
		content = item;
	}
	@Override //Override annotation
	public String toString()
	{
		return "Item stored in the box"+ content;
	}
}

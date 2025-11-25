package com.app.raw;

public class GenericBox<T> {//creates a new class GenericBox
	private T item;
	public GenericBox(T item)
	{
		this.item = item;
	}
	
	public T getItem() //getter method
	{
		return item;
	}
	
	public static void main(String[] args)//main method
	{
		GenericBox<Integer> integerBox = new GenericBox<>(456);//creating object integerBox
	 	GenericBox<String> stringBox = new GenericBox<>("Java Generics");//creating object stringBox
	 	integerBox = new GenericBox<>("WrongType");//compilation error occurs here
	 	int a = integerBox.getItem();
	 	String b = stringBox.getItem();
	 	System.out.println(a);
	 	System.out.println(b);
	}
}


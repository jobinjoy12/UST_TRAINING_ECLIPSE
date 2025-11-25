package com.java.gener;

public class Main {
	public static void main(String[] args) {
	Box<Integer> integerBox = new Box<>(123); //Creates a new object for Box with type Integer
	Box<String> stringBox = new Box<>("Hello Generics"); //Creates a new object for Box with type Strings
	System.out.println(integerBox.toString());
	System.out.println(stringBox.toString());
	integerBox.setItem(909);
	System.out.println(integerBox.toString());
	Integer[] intArray = {1, 5, 9, 13};
	ArrayUtils.printArray(intArray);
	String[] stringArray = {"apple", "banana", "cherry"};
	ArrayUtils.printArray(stringArray);
	}
}

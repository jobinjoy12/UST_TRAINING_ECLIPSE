package com.app.generic;

public class Main {
	public static void main(String[] args)
	{
		ObjectContainer oc = new ObjectContainer("Hello Generics"); //creating object
		IntegerContainer ic = new IntegerContainer(12);
		StringContainer sc = new StringContainer("Hello");
		String l = sc.getItem();
		System.out.println(l.length());
		int in = ic.getItem();
		System.out.println(in + 10);
		String a = (String)oc.getItem(); //casting
		System.out.println(a.length());	
		ObjectContainer oc2 = new ObjectContainer(123); //creating object
		int nt = (Integer)oc2.getItem();
		System.out.println(nt+5);
		ObjectContainer oc3 = new ObjectContainer(456);
		String b = (String)oc3.getItem();//ClassCastException occurs here because we are converting an Integer to String through explicit casting.
	}
}

package com.app.overload;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args)
	{
		AreaCalculator ac = new AreaCalculator();
		System.out.println("Area of Square: "+ac.calculateArea(5));
		System.out.println("Area of Rectangle: "+ac.calculateArea(5,6));
		System.out.println("Area of Circle: "+ac.calculateArea(5,true));
		
		ArrayList<Shape> arr = new ArrayList<>();
		Circle a = new Circle(5);
		arr.add(a);
		Rectangle r = new Rectangle(5,6);
		arr.add(r);
		for(Shape b: arr)
		{	
			b.draw();
			System.out.println(b.getArea());
		}
	}
}

package com.app.cast;


public class Main {
	public static void main(String[] args)
	{
		Circle c = new Circle();
		Rectangle r  = new Rectangle();
		Shape[] ar = new Shape[1];
		ar[0] = c;
		ar[1] = r;
		for(Shape s : ar)
		{
			s.draw();
			s.getAreaDescription();
			if(s instanceof Circle)
			{
				System.out.println("This is a Circle with radius: "+((Circle) s).getRadius());
			}
			if(s instanceof Rectangle)
			{
				System.out.println("This is a Rectangle with length: "+((Rectangle)s).getLength()+" and width "+((Rectangle)s).getWidth());
			}
		}
	}
}

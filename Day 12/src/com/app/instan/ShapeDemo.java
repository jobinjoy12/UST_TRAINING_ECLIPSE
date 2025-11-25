package com.app.instan;

import java.util.ArrayList;

public class ShapeDemo {
	public static void main(String[] args)
	{
		ArrayList<Shape> list = new ArrayList<>();
		Circle c = new Circle(5.0);
		Rectangle r = new Rectangle(4.0,6.0);
		Circle e = new Circle(3.5);
		list.add(c);
		list.add(r);
		list.add(e);
		for(Shape s : list)
		{
			if(s instanceof Circle)
			{
				Circle g = (Circle) s;
				System.out.println("Circle with radius "+g.getRadius()+" , Area"+g.getArea());
			}
			if(s instanceof Rectangle)
			{
				Rectangle t = (Rectangle) s;
				System.out.println("Rectangle with width: "+t.getWidth()+" ,height: "+t.getHeight());
			}
		}
	}
}

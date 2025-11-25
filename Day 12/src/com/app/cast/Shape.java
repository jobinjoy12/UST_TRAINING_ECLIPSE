package com.app.cast;

public abstract class Shape {
	public abstract void draw() ;
	public String getAreaDescription() {
		return "Area is not specified for a generic shape.";
	}
}

class Circle extends Shape{
	@Override
	public void draw()
	{
		System.out.println("Drawing a Circle");
	}
	public int getRadius()
	{
		return 5;
	}
}

class Rectangle extends Shape
{
	@Override
	public void draw()
	{
		System.out.println("Drawing a Rectangle");
	}
	public int getLength()
	{
		return 10;
	}
	public int getWidth()
	{
		return 4;
	}
}

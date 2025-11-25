package com.app.overload;

public class Shape {
	public void draw()
	{
		System.out.println("Drawing a generic shape");
	}
	public double getArea()
	{
		return 0.0;
	}
}

class Circle extends Shape
{
	private double radius;
	public Circle(double radius) {
		this.radius = radius;
	}
	@Override
	public void draw()
	{
		System.out.println("Drawing a Circle with radius "+radius);
	}
	@Override
	public double getArea()
	{
		return Math.PI*radius*radius;
	}
}

class Rectangle extends Shape
{
	private double length;
	private	double width;
	public Rectangle(double length , double width)
	{
		this.length = length;
		this.width = width;
	}
	@Override
	public void draw()
	{
		System.out.println("Drawing a Rectangle with length "+length+" and width "+width);
	}
	@Override
	public double getArea()
	{
		return length*width;
	}
}
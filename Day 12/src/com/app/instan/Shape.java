package com.app.instan;

public abstract class Shape {
	public abstract double getArea() ;
}

class Circle extends Shape
{
	private double radius;
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public Circle(double radius)
	{
		this.radius = radius;
	}
	@Override
	public double getArea()
	{
		return Math.PI*radius*radius;
	}
}

class Rectangle extends Shape
{
	private double height;
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	private double width ;
	public Rectangle(double height , double width)
	{
		this.height = height;
		this.width = width;
	}
	@Override
	public double getArea()
	{
		return width*height;
	}
}


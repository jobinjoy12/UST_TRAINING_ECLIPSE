package com.app.override;

public class Rectangle extends Shape {
	private double width;
	private double height;
	
	public Rectangle(double width, double height)
	{
		this.height = height;
		this.width = width;
	}
	@Override
	public double calculateArea() {
		return width*height;
	}
}

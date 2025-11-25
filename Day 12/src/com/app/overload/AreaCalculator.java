package com.app.overload;

public class AreaCalculator {
	public double calculateArea(double side)
		{
			double Area = side*side;
			return Area;
		}
	public double calculateArea(double length, double width)
		{
			double Area = length * width;
			return Area;
		}
	public double calculateArea(double radius, boolean isCircle)
	{
		if(isCircle == true)
		{
			double Area = Math.PI*radius*radius;
			return Area;
		}
		return 0.0;
		 
	}
}

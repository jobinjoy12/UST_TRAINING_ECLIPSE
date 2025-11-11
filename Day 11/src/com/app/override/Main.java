package com.app.override;

public class Main {
	public static void main(String[] args) {
		Circle circle = new Circle(5.0);
		Rectangle rectangle = new Rectangle(4.0,6.0);
		System.out.println(circle.calculateArea());
		System.out.println(rectangle.calculateArea());
		circle.displayMessage();
		rectangle.displayMessage();
	}
}

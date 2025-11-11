package com.app.hier;

public class Motorcycle extends Vehicle {
	boolean hasSideCar;
	public Motorcycle(String make , String model ,int year,boolean hasSideCar)
	{
		super(make,model,year);
		this.hasSideCar = hasSideCar;
	}
	@Override
	public void displayInfo() {
		System.out.println("hasSideCar: "+hasSideCar);
	}
	public void wheelie() {
		System.out.println("The motorcycle performs a wheelie!");
	}
}

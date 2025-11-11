package com.app.hier;

public class Car extends Vehicle {
	int numDoors;
	public Car(String make, String model , int year , int numDoors)
	{
		super(make,model,year);
		this.numDoors = numDoors;
	}
	@Override
	public void displayInfo() {
		System.out.println("Number of Doors: "+numDoors);
	}
	public void honk() {
		System.out.println("The car honks!");
	}
}

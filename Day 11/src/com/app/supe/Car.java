package com.app.supe;

public class Car extends Vehicle {
	private int  numberOfDoors;
	public Car(String make , String model , int year , int numberOfDoors) {
		super(make,model,year);
		this.numberOfDoors = numberOfDoors;
	}
	@Override
	public void displayVehicleInfo()
	{
		super.displayVehicleInfo();
		System.out.println("NoOfDoors :"+numberOfDoors);
	}
}

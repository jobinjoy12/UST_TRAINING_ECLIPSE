package com.app.hier;

public class Vehicle {
	protected String make;
	protected String model;
	protected int year;
	public Vehicle(String make,String model ,int year) {
		this.make = make;
		this.model = model;
		this.year = year;
	}
	public void displayInfo() {
		System.out.println("Model :"+model
				+" Make :"+make+
				" Year :"+year);
	}
	public void startEngine() {
		System.out.println("The vehicle's engine starts.");
	}
}

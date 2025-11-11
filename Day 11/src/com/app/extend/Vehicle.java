package com.app.extend;

public class Vehicle {
	private String brand;
	
	public Vehicle(String brand) {
		this.brand = brand ;
	}
	
	public void start()
	{
		System.out.println("The vehicle starts");
	}
	public String getBrand() {
		return brand;
	}
}

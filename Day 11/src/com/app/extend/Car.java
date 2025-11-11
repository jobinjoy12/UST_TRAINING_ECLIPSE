package com.app.extend;

public class Car extends Vehicle{
	private String model;
	public Car(String brand,String model)
	{
		super(brand);
		this.model = model;
	}
	@Override
	public void start()
	{
		System.out.println("The "+getBrand()+" "+model+" car starts with a roar!");
	}
	public void drive()
	{
		System.out.println("The "+getBrand()+" "+model+" car is driving.");
	}
}

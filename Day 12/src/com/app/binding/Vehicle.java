package com.app.binding;

public class Vehicle {
	public void startEngine()
	{
		System.out.println("Vehicle engine starting...");
	}
}

class Car extends Vehicle{
	@Override
	public void startEngine()
	{
		System.out.println("Car engine starting with key ignition.");
	}
}

class Motorcycle extends Vehicle{
	@Override
	public void startEngine()
	{
		System.out.println("Motorcycle engine starting with kick-start.");
	}
}
package com.app.vehicle;

public class Car extends Vehicle {
	private int numDoors;
	private Engine engine;
	public Car(int speed , int numDoors,Engine engine) {
		super(speed);
		this.numDoors = numDoors;
		this.engine = engine;
	}
	@Override
	public void accelerate() {
		System.out.println("Car is accelerating with "+speed);
	}
	public void startCar() {
		engine.start();
	}
}


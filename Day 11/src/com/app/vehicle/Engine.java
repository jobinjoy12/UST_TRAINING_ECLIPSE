package com.app.vehicle;

public class Engine {
	private int horsepower;
	public Engine(int horsepower) {
		this.horsepower = horsepower;
	}
	
	public void start() {
		System.out.println("Engine with "+horsepower+" HP started!");
	}
}

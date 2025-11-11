package com.app.vehicle;

public class TransportationSystem {
	public static void main(String[] args)
	{
		Engine eng = new Engine(200);
		Car car = new Car(200,5,eng);
		car.accelerate();
		car.startCar();
	}
}

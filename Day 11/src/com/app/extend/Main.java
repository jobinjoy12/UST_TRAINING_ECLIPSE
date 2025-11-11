package com.app.extend;

public class Main {
	public static void main(String[] args)
	{
		Vehicle myBike = new Vehicle("Bicycle Brand");
		myBike.start();
		Car myCar = new Car("Toyota","Camry");
		myCar.start();
		myCar.drive();
	}
}	

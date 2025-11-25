package com.app.poly;

import java.util.ArrayList;

public class VehicleSimulator {
	public static void main(String[] args)
	{
		Car c = new Car("Honda Civic");
		Bicycle b = new Bicycle("Mountain Bike");
		Airplane a  = new Airplane("Boeing 747");
		
		ArrayList<Vehicle> ar = new ArrayList<>();
		ar.add(c);
		ar.add(b);
		ar.add(a);
		for(Vehicle v : ar)
		{
			v.move();
		}
	}
}
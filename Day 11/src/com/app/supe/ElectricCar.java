package com.app.supe;

public class ElectricCar extends Car{
	private int batteryCapacityKWh;
	public ElectricCar(String make , String model , int year , int numberOfDoors , int batteryCapacityKWh)
	{
		super(make,model,year,numberOfDoors);
		this.batteryCapacityKWh = batteryCapacityKWh;
	}
	
	@Override
	public void displayVehicleInfo() {
		super.displayVehicleInfo();
		System.out.println(batteryCapacityKWh);
	}
}

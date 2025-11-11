package com.app.supe;

public class Main {
	public static void main(String[] args)
	{
		Vehicle veh = new Vehicle("Toyota","Camery",2001);
		Car car = new Car("Suzuki","Swift",2003,4);
		ElectricCar ec = new ElectricCar("Hyundai","ion",2020,5,10000);
		veh.displayVehicleInfo();
		car.displayVehicleInfo();
		ec.displayVehicleInfo();
	}
}

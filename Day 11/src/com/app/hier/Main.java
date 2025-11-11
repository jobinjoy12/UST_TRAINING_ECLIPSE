package com.app.hier;

public class Main {
		public static void main(String[] args) {
			Car car = new Car("Toyota","Fortuner",1998,4);
			Motorcycle bike = new Motorcycle("KTM","Duke",2002,false);
			car.displayInfo();
			bike.displayInfo();
			car.startEngine();
			bike.startEngine();
			car.honk();
			bike.wheelie();
			
		}
}

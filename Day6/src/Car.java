
public class Car {
	String model ;
	int year;
	double fuelLevel = 50.0;;
	static int totalCarsCreated;
	Car(String model , int year){
		this.model = model;
		this.year = year ;
		fuelLevel = 50.0;
		Car.totalCarsCreated++;
	}
	void startEngine() {
		System.out.println(model+"Enginer Created");
	}
	
	void drive(double distance) {
		fuelLevel -= distance * 0.1;
		System.out.println(fuelLevel);
		if(fuelLevel <0) {
			System.out.println("Out of Fuel");
			fuelLevel = 0;
		}
	}
	void refuel(double amount) {
		fuelLevel += amount ;
		System.out.println(fuelLevel);
	}
	
	static int getTotalCars() {
		return totalCarsCreated ;
	}
	static String getCarManufacturerInfo() {
		return "All cars are manufactured for transporting purposes.";
	}
	
	public static void main(String[] args) {
		Car obj1 = new Car("Toyota",2005);
		Car obj2 = new Car("Maruti",2001);
		obj1.startEngine();
		obj1.drive(2000);
		obj1.refuel(1000);
		obj2.startEngine();
		obj2.drive(1500);
		obj2.refuel(1000);
		System.out.println(getTotalCars());
		System.out.println(getCarManufacturerInfo());
		
	}
}

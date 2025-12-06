//Create a base class "Vehicle" with a method "public String startEngine()". Implement two subclasses,
//"Car" and "Motorcycle", that extend "Vehicle" and override "startEngine()" to
//return specific messages (e.g., 'Car engine started.' and 'Motorcycle engine started.'). 
//		Demonstrate polymorphism by creating an array of "Vehicle" objects, 
//		adding instances of "Car" and "Motorcycle" to it, and iterating through the array to call "startEngine()" on each.
package Question1;


class Vehicle {
	public String startEngine() {
		return "Vehicle engine started.";
	}
	
	class Car extends Vehicle
	{
		@Override
		public String startEngine()
		{
			return "Car engine started.";
		}
	}
	class Motorcycle extends Vehicle
	{
		@Override
		public String startEngine()
		{
			return "Motorcycle engine started.";
		}
	}
}
public class Main{
	public static void main(String[] args) {
		Vehicle[] newArr = new Vehicle[2];
		newArr[0] = new Vehicle.Car();
		newArr[1] = new Vehicle.Motorcycle();
		for(Vehicle veh : newArr)
		{
			veh.startEngine();
		}
		
		
	}
}

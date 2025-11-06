class Printer{
	void print(int value){
		System.out.println("Printing int: "+value);
	}
	void print(double value){
		System.out.println("Printing double: "+value);
	}
	void print(String value){
		System.out.println("Printing String: "+value);
	}
	void print(boolean value){
		System.out.println("Printing boolean: "+value);
	}
}

class Calculator{
	int add(int a , int b ) {
		int sum = a+b;
		return sum;
	}
	double add(double a , double b) {
		double sum = a+b;
		return sum;
	}
		double add(int a , double b){
			double sum = (double)a + b; 
					return sum;
		}
}

public class Main {
	public static void main(String[] args) {
		Printer myPrinter = new Printer();
		myPrinter.print(10);
		myPrinter.print(3.14);
		myPrinter.print("Hello Overloading!");
		myPrinter.print(true);

		// For Calculator class
		Calculator myCalculator = new Calculator();
		System.out.println("Sum of ints: " + myCalculator.add(5, 7));
		System.out.println("Sum of doubles: " + myCalculator.add(10.5, 20.3));
		System.out.println("Sum of int and double: " + myCalculator.add(10, 5.5));
	}
}

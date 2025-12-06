import java.util.Scanner;

public class SimpleCalculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Cannot divide by zero.");
            return 0.0;
        }
        // Cast one number to double to ensure decimal results (e.g., 5/2 = 2.5)
        return (double) a / b;
    }

    public static void performCalculation() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        
        System.out.print("Enter operation (+, -, *, /): ");
        String operation = scanner.next();

        SimpleCalculator calculator = new SimpleCalculator();

        switch (operation) {
            case "+":
                System.out.println("Result: " + calculator.add(num1, num2));
                break;
            case "-":
                System.out.println("Result: " + calculator.subtract(num1, num2));
                break;
            case "*":
                System.out.println("Result: " + calculator.multiply(num1, num2));
                break;
            case "/":
                System.out.println("Result: " + calculator.divide(num1, num2));
                break;
            default:
                System.out.println("Invalid operation selected.");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        // Uncomment to run the interactive mode
        performCalculation();
    }
}
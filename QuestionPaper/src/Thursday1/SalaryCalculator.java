package Thursday1;

import java.util.Scanner;

public class SalaryCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double hourlyRate = 0;
        double hoursWorked = 0;

        // Get valid hourly rate
        while (hourlyRate <= 0) {
            System.out.println("Enter the hourly rate");
            hourlyRate = scanner.nextDouble();
            if (hourlyRate <= 0) {
                System.out.println("Enter positive number");
            }
        }

        // Get valid hours worked
        while (hoursWorked <= 0) {
            System.out.println("Enter the hours worked");
            hoursWorked = scanner.nextDouble();
            if (hoursWorked <= 0) {
                System.out.println("Enter positive number");
            }
        }

        double salary = hourlyRate * hoursWorked;
        System.out.println("Gross Salary: " + salary);

        scanner.close();
    }
}
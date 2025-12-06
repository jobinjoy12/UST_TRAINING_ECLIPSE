package Thursday1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Employee {
	private String id;
	private String name;
	private double salary;

	public Employee(String id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	// Getters
	public String getId() { return id; }
	public String getName() { return name; }
	public double getSalary() { return salary; }

	@Override
	public String toString() {
		return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
	}
}

public class EmployeeManagementSystem {
	private List<Employee> employees = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);

	public void run() {
		boolean running = true;
		while (running) {
			displayMenu();
			try {
				System.out.print("Enter your choice: ");
				int choice = scanner.nextInt();
				scanner.nextLine(); // Consume newline

				switch (choice) {
					case 1:
						addEmployee();
						break;
					case 2:
						viewEmployees();
						break;
					case 3:
						running = false;
						System.out.println("Exiting system.");
						break;
					default:
						System.out.println("Invalid choice. Please try again.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number.");
				scanner.nextLine(); // Consume the invalid input
			} catch (Exception e) {
				System.out.println("An unexpected error occurred: " + e.getMessage());
			}
		}
		scanner.close();
	}

	private void displayMenu() {
		System.out.println("--- Employee Management System ---");
		System.out.println("1. Add Employee");
		System.out.println("2. View Employees");
		System.out.println("3. Exit");
	}

	private void addEmployee() {
		// Your code here to prompt for employee details and add to 'employees' list
		System.out.println("Enter the details");
		String id = scanner.nextLine();
		if(id.equals("")) {
			id = scanner.nextLine();
		}
		String name = scanner.nextLine();
		if(name.equals("")) {
			name = scanner.nextLine();
		}
		Double salary = -1;
		while(salary < 0) {
		System.out.println("Enter the salary");
		salary = scanner.nextDouble();
		if(salary < 0)
			System.out.println("enter valid digit");
		}
		
		Employee e = new Employee(id,name,salary);
		employees.add(e);
		}
	
		
	

	private void viewEmployees() {
		// Your code here to display all employees or a message if list is empty
		if(employees.isEmpty()) {
			System.out.println("empty list");
			return ;
		}
		else {
			for(Employee e:employees)
			{
				System.out.println(e);
			}
		}
	}

	public static void main(String[] args) {
		new EmployeeManagementSystem().run();
	}
}
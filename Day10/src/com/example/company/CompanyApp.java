package com.example.company;

public class CompanyApp {
	public static void main(String[] args) {
		Employee emp = new Employee("Alice", 101, "Sales", 60000.0);
		Manager mgr = new Manager("Bob", 201, "IT", 90000.0, "Project X");
		System.out.println("Name: "+emp.name+", ID: "+emp.employeeId+", Department: "+emp.department+", Salary: "+emp.salary);
		System.out.println("Name: "+mgr.name+", ID: "+mgr.employeeId+", Department: "+mgr.department+", Salary: "+mgr.salary+", ProjectName: "+mgr.projectName);
		emp.getEmployeeDetails();
		emp.displaySalaryInfo();
		mgr.displayManagerDetails();
		emp.calculateAnnualBonus();

	}
}
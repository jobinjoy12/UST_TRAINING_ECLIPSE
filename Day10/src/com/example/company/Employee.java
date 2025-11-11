package com.example.company;

public class Employee {
		private String name;
		int employeeId;
		protected String department;
		public double salary;
		public Employee(String name,int id , String department, double salary) {
			this.name = name ;
			this.employeeId= id;
			this.department = department;
			this.salary = salary;
		}
		public String getEmployeeDetails()
		{
			return "Name: "+name+" EmployeeId: "+employeeId;
		}
		private double calculateAnnualBonus() 
		{
			return salary*0.10;
		}
		public void displaySalaryInfo() 
		{
			double n = calculateAnnualBonus();
			System.out.println("Name: "+name+" Salary: "+salary+" Annual Bonus: "+n);
		}
}

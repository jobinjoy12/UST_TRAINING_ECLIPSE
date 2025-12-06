package Thursday1;

public class Employee {
	private String id;
	private String name;
	private double hoursWorked;
	private double hourlyRate;

	public Employee(String id, String name, double hoursWorked, double hourlyRate) {
		this.id = id;
		this.name = name;
		this.hoursWorked = hoursWorked;
		this.hourlyRate = hourlyRate;
	}

	// Getters
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	// Setters with validation
	public void setHoursWorked(double hoursWorked) {
		// Your code here to validate hoursWorked or throw IllegalArgumentException
		if(hoursWorked <0) {
			throw new IllegalArgumentException("Invalid value");
		}
		this.hoursWorked=hoursWorked ;
	}

	public void setHourlyRate(double hourlyRate) {
		// Your code here to validate hourlyRate or throw IllegalArgumentException
		if(hourlyRate <=0) {
			throw new IllegalArgumentException("bad value");
		}
		this.hourlyRate = hourlyRate;
	}

	public double calculateGrossSalary() {
		
		// Your code here
		return (getHoursWorked()*getHourlyRate());
	}

	public double calculateNetSalary(double taxRate) {
		// Your code here
		return (calculateGrossSalary() -((taxRate * calculateGrossSalary())/calculateGrossSalary()));
	}

	public static void main(String[] args) {
		// Test your Employee class here
		try{Employee e = new Employee("1","jobin",10.0,100.0);
		Employee e1 = new Employee("2","Niranj",-15.0,1000);
		Employee e2 = new Employee("3","Sarath",1000,0);}catch(IllegalArgumentException e) {System.out.println("bad values");}
		
	}
}
package Thursday1;

class InvalidSalaryException extends Exception {
	public InvalidSalaryException(String message) {
		super(message);
	}
}

class Employee {
	private String name;
	private double baseSalary;

	public Employee(String name, double baseSalary) throws InvalidSalaryException {
		// Your code here to validate baseSalary and set fields, or throw InvalidSalaryException
		this.name = name ;
		if(baseSalary < 1000 || baseSalary > 10000)
		{
			throw new InvalidSalaryException("Invalid value");
		}
		else {
			this.baseSalary = baseSalary;
		}
	}

	public String getName() {
		return name;
	}

	public double getBaseSalary() {
		return baseSalary;
	}
}

public class SalaryValidator {
	public static void main(String[] args) {
		// Your code here to test Employee object creation with valid and invalid salaries
		try{Employee e = new Employee("jobin",1200);
		Employee e2 = new Employee("niranj",-9);}catch(InvalidSalaryException e){System.out.println(e.getMessage());}
		
	}
}
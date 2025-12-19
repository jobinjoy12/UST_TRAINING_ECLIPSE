package com.example.employeemanager.service;

import java.util.List;
import java.util.Optional;

import com.example.employeemanager.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	

	Optional<Employee> getEmployeeById(int id);

	Employee addEmployee(Employee employee);

	Employee updateEmployee(int id, Employee employee);

	void deleteEmployee(int id);

	List<Employee> searchEmployeesByDepartment(String department);

	List<Employee> getEmployeesSortedBySalary();

	Employee partialUpdateEmployee(int id, Employee updates);

	long countEmployees();

	void clearAllEmployees();

	// Methods for persistence
	void loadEmployeesFromFile();

	void saveEmployeesToFile();
}
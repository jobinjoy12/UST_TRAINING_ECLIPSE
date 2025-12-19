package com.example.employeemanager.service;

import com.example.employeemanager.exception.DuplicateEmployeeException;
import com.example.employeemanager.exception.EmployeeNotFoundException;
import com.example.employeemanager.model.Employee;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private List<Employee> employees = new ArrayList<>();
    private AtomicInteger nextId = new AtomicInteger(1);
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String DATA_FILE_PATH = "src/main/resources/employees.json";

    @PostConstruct
    public void init() {
        loadEmployeesFromFile();
        if (!employees.isEmpty()) {
            int maxId = employees.stream().mapToInt(Employee::getId).max().orElse(0);
            nextId.set(maxId + 1);
        }
    }

    @PreDestroy
    public void destroy() {
        saveEmployeesToFile();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        if (employees.stream().anyMatch(e -> e.getName().equalsIgnoreCase(employee.getName()))) {
            throw new DuplicateEmployeeException("Employee with name '" + employee.getName() + "' already exists.");
        }
        employee.setId(nextId.getAndIncrement());
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(int id, Employee updatedEmployee) {
        return getEmployeeById(id)
                .map(existingEmployee -> {
                    existingEmployee.setName(updatedEmployee.getName());
                    existingEmployee.setDepartment(updatedEmployee.getDepartment());
                    existingEmployee.setSalary(updatedEmployee.getSalary());
                    return existingEmployee;
                })
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found."));
    }

    @Override
    public void deleteEmployee(int id) {
        boolean removed = employees.removeIf(e -> e.getId() == id);
        if (!removed) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
        }
    }

    @Override
    public List<Employee> searchEmployeesByDepartment(String department) {
        return employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getEmployeesSortedBySalary() {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Employee partialUpdateEmployee(int id, Employee updates) {
        return getEmployeeById(id)
                .map(existingEmployee -> {
                    if (updates.getName() != null) {
                        existingEmployee.setName(updates.getName());
                    }
                    if (updates.getSalary() != 0.0) {
                        existingEmployee.setSalary(updates.getSalary());
                    }
                    return existingEmployee;
                })
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found."));
    }

    @Override
    public long countEmployees() {
        return employees.size();
    }

    @Override
    public void clearAllEmployees() {
        employees.clear();
        nextId.set(1);
    }

    @Override
    public void loadEmployeesFromFile() {
        File file = new File(DATA_FILE_PATH);
        if (file.exists() && file.length() > 0) {
            try {
                employees = objectMapper.readValue(file, new TypeReference<List<Employee>>() {});
                System.out.println("Loaded " + employees.size() + " employees from " + DATA_FILE_PATH);
            } catch (IOException e) {
                System.err.println("Error loading employees from file: " + e.getMessage());
            }
        } else {
            System.out.println("No existing employee data file found or file is empty: " + DATA_FILE_PATH);
            this.employees = new ArrayList<>();
        }
    }

    @Override
    public void saveEmployeesToFile() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(DATA_FILE_PATH), employees);
            System.out.println("Saved " + employees.size() + " employees to " + DATA_FILE_PATH);
        } catch (IOException e) {
            System.err.println("Error saving employees to file: " + e.getMessage());
        }
    }
}
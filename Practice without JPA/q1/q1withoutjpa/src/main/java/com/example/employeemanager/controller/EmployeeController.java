package com.example.employeemanager.controller;

import com.example.employeemanager.model.Employee;
import com.example.employeemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // GET /employees → return all employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // GET /employees/{id} → return employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        // Service throws EmployeeNotFoundException if not found, handled globally
        return ResponseEntity.ok(employeeService.getEmployeeById(id).orElseThrow(() -> new RuntimeException("Employee not found"))); 
        // Replace RuntimeException with EmployeeNotFoundException if you want explicit throw here
    }

    // POST /employees → add new employee
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    // PUT /employees/{id} → update employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    // DELETE /employees/{id} → delete employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    // GET /employees/search?department=IT → search employees by department
    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchEmployeesByDepartment(@RequestParam String department) {
        return ResponseEntity.ok(employeeService.searchEmployeesByDepartment(department));
    }

    // GET /employees/sortBySalary → employees sorted by salary (desc)
    @GetMapping("/sortBySalary")
    public ResponseEntity<List<Employee>> getEmployeesSortedBySalary() {
        return ResponseEntity.ok(employeeService.getEmployeesSortedBySalary());
    }

    // PATCH /employees/{id} → partial update (only name or salary)
    @PatchMapping("/{id}")
    public ResponseEntity<Employee> partialUpdateEmployee(@PathVariable int id, @RequestBody Employee updates) {
        Employee updatedEmployee = employeeService.partialUpdateEmployee(id, updates);
        return ResponseEntity.ok(updatedEmployee);
    }

    // GET /employees/count → return total number of employees
    @GetMapping("/count")
    public ResponseEntity<Map<String, Long>> countEmployees() {
        long count = employeeService.countEmployees();
        return ResponseEntity.ok(Collections.singletonMap("totalEmployees", count));
    }

    // DELETE /employees → clear all employees
    @DeleteMapping
    public ResponseEntity<Void> clearAllEmployees() {
        employeeService.clearAllEmployees();
        return ResponseEntity.noContent().build();
    }
}
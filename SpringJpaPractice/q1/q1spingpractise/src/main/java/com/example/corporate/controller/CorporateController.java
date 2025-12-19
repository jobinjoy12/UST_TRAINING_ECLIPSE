package com.example.corporate.controller;

import com.example.corporate.model.Department;
import com.example.corporate.model.Employee;
import com.example.corporate.service.CorporateService;
import com.example.corporate.dto.DepartmentRequest;
import com.example.corporate.dto.EmployeeRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CorporateController {

    @Autowired
    private CorporateService corporateService;

    // TODO: Implement REST endpoints for managing Departments.
    // This should include:
    // - POST /departments: Create a new Department.
    // - GET /departments: Retrieve all Departments.
    // - GET /departments/{id}: Retrieve a Department by ID.
    // - PUT /departments/{id}: Update an existing Department.
    // - DELETE /departments/{id}: Delete a Department.

    @PostMapping("/departments")
    public ResponseEntity<Department> createDepartment(@RequestBody DepartmentRequest request) {
        // TODO: Call CorporateService to create a department. Return appropriate HTTP status and the created department.
        Department dept = corporateService.createDepartment(request);

        return new ResponseEntity<>(dept , HttpStatus.CREATED);
    }

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getAllDepartments() {
        // TODO: Call CorporateService to get all departments. Return appropriate HTTP status and the list of departments.
        List<Department> list = corporateService.getAllDepartments();
        return new ResponseEntity<>(list,  HttpStatus.OK);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
    Optional<Department> opt = corporateService.getDepartmentById(id);

    if (opt.isPresent()) {
        return ResponseEntity.ok(opt.get()); // 200 OK with department
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 if not found
    }
    }

    @PutMapping("/departments/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody DepartmentRequest request) {
        // TODO: Call CorporateService to update a department. Handle not found cases with 404 NOT FOUND.
        
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        // TODO: Call CorporateService to delete a department. Handle not found cases with 404 NOT FOUND.
        // Return 204 NO CONTENT on successful deletion.
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    // TODO: Implement REST endpoints for managing Employees.
    // This should include:
    // - POST /employees: Create a new Employee (and associate with a department).
    // - GET /employees: Retrieve all Employees.
    // - GET /employees/{id}: Retrieve an Employee by ID.
    // - PUT /employees/{id}: Update an existing Employee (including changing department).
    // - DELETE /employees/{id}: Delete an Employee.

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeRequest request) {
        // TODO: Call CorporateService to create an employee. Return appropriate HTTP status and the created employee.
        
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        // TODO: Call CorporateService to get all employees. Return appropriate HTTP status and the list of employees.
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        // TODO: Call CorporateService to get an employee by ID. Handle not found cases with 404 NOT FOUND.
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequest request) {
        // TODO: Call CorporateService to update an employee. Handle not found cases with 404 NOT FOUND.
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        // TODO: Call CorporateService to delete an employee. Handle not found cases with 404 NOT FOUND.
        // Return 204 NO CONTENT on successful deletion.
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    // TODO: Include an endpoint to demonstrate the one-to-many relationship,
    // such as retrieving all employees within a specific department.
    @GetMapping("/departments/{departmentId}/employees")
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable Long departmentId) {
        // TODO: Call CorporateService to get employees by department ID. Handle not found cases with 404 NOT FOUND.
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
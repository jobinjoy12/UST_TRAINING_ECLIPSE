package com.example.erp.controller;

import com.example.erp.model.Department;
import com.example.erp.model.Employee;
import com.example.erp.repository.DepartmentRepository;
import com.example.erp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public DepartmentController(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    // Create new departments (POST /departments)
    @PostMapping("/departments")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department dept = departmentRepository.save(department) ;

        // TODO: Implement logic to create a new department.
        //  Save the department using departmentRepository and return it with HttpStatus.CREATED.
        return new ResponseEntity<>(dept, HttpStatus.CREATED);
    }

    // Add employees to a specific department (POST /departments/{departmentId}/employees)
    @PostMapping("/departments/{departmentId}/employees")
    public ResponseEntity<Employee> addEmployeeToDepartment(@PathVariable Long departmentId, @RequestBody Employee employee) {
        Optional<Department> dept = departmentRepository.findById(departmentId);
        if(dept.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dept.get().addEmployee(employee);
        employee.setDepartment(dept.get());
        Employee empl = employeeRepository.save(employee);
        // TODO: Implement logic to add an employee to a specific department.
        //  1. Find the department by ID using departmentRepository.findById.
        //  2. If the department exists, add the employee to its list of employees, set the employee's department,
        //     and save both the department and the employee (or just the employee, depending on cascade settings).
        //  3. Return the saved employee with HttpStatus.CREATED. If department not found, return HttpStatus.NOT_FOUND.
        return new ResponseEntity<>(empl , HttpStatus.CREATED);
    }

    // Retrieve all employees belonging to a specific department (GET /departments/{departmentId}/employees)
    @GetMapping("/departments/{departmentId}/employees")
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable Long departmentId) {
        // TODO: Implement logic to retrieve all employees belonging to a specific department.
        Optional<Department> dept = departmentRepository.findById(departmentId);
        if(dept.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        List<Employee> list = dept.get().getEmployees();
        //  1. Find the department by ID using departmentRepository.findById.
        //  2. If the department exists, return its list of employees with HttpStatus.OK.
        //  3. If department not found, return HttpStatus.NOT_FOUND.
        return new ResponseEntity<>(list ,HttpStatus.OK);
    }

    // Endpoint to use the JPQL query to list employees whose salary exceeds a given minimum value.
    @GetMapping("/employees/salary-greater-than")
    public ResponseEntity<List<Employee>> getEmployeesWithSalaryGreaterThan(@RequestParam double minSalary) {
        // TODO: Call the JPQL query method from employeeRepository to list employees whose salary exceeds the given minimum value.
        //  Return the list of employees with HttpStatus.OK.
        List<Employee> list = employeeRepository.findEmployeesWithSalaryGreaterThan(minSalary);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
package com.example.corporate.service;

import com.example.corporate.model.Department;
import com.example.corporate.model.Employee;
import com.example.corporate.repository.DepartmentRepository;
import com.example.corporate.repository.EmployeeRepository;
import com.example.corporate.dto.DepartmentRequest;
import com.example.corporate.dto.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CorporateService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    // TODO: Implement business logic for managing Departments.
    // This should include:
    // - Create a new Department.
    // - Retrieve a Department by its ID.
    // - Retrieve all Departments.
    // - Update an existing Department.
    // - Delete a Department.

    @Transactional
    public Department createDepartment(DepartmentRequest request) {
        Department dept = new Department();
        dept.setName(request.getName());
        

        // TODO: Implement logic to create and save a new Department entity.
        // Example: Department department = new Department(); department.setName(request.getName()); return departmentRepository.save(department);
        return departmentRepository.save(dept);
    }

    public Optional<Department> getDepartmentById(Long id) {
        // TODO: Implement logic to retrieve a Department by its ID.
        // Example: return departmentRepository.findById(id);

        return departmentRepository.findById(id);
    }

    public List<Department> getAllDepartments() {
        // TODO: Implement logic to retrieve all Departments.
        // Example: return departmentRepository.findAll();
        return departmentRepository.findAll();
    }

    @Transactional
    public Department updateDepartment(Long id, DepartmentRequest request) {
        // TODO: Implement logic to find, update, and save an existing Department.
        // Throw an exception (e.g., RuntimeException or custom NotFoundException) if the Department is not found.
        // Example: return departmentRepository.findById(id).map(department -> { department.setName(request.getName()); return departmentRepository.save(department); }).orElseThrow(() -> new RuntimeException("Department not found"));
        return departmentRepository.findById(id).map(dept ->{ dept.setName(request.getName());return departmentRepository.save(dept); }).orElseThrow(()-> new RuntimeException("Not FOund"));
    }

    @Transactional
    public void deleteDepartment(Long id) {
        // TODO: Implement logic to delete a Department by its ID.
        departmentRepository.findById(id).ifPresent(dept->departmentRepository.deleteById(id));
        // Consider handling cases where the department has associated employees (e.g., cascading delete, or disallowing delete).
        // Example: departmentRepository.deleteById(id);
        if(departmentRepository.existsById(id))
        {
            departmentRepository.deleteById(id);
        }
    }


    // TODO: Implement business logic for managing Employees.
    // This should include:
    // - Create a new Employee, associating it with an existing Department.
    // - Retrieve an Employee by its ID.
    // - Retrieve all Employees.
    // - Update an existing Employee (including changing department).
    // - Delete an Employee.

    @Transactional
    public Employee createEmployee(EmployeeRequest request) {
        // TODO: Implement logic to create and save a new Employee entity.
        // Ensure the employee is associated with an existing department. Handle cases where departmentId is invalid.
        // Example: Department department = departmentRepository.findById(request.getDepartmentId()).orElseThrow(() -> new RuntimeException("Department not found")); Employee employee = new Employee(); employee.setFirstName(request.getFirstName()); ... employee.setDepartment(department); department.addEmployee(employee); return employeeRepository.save(employee);
       Department dept = departmentRepository.findById(request.getDepartmentId()).orElseThrow(()-> new RuntimeException("Not found"));
       
        Employee emp = new Employee();
emp.setFirstName(request.getFirstName());
emp.setLastName(request.getLastName());
emp.setPosition(request.getPosition());
emp.setDepartment(dept);

return employeeRepository.save(emp);
    }

    public Optional<Employee> getEmployeeById(Long id) {
        // TODO: Implement logic to retrieve an Employee by its ID.
        // Example: return employeeRepository.findById(id);
        return employeeRepository.findById(id);
    }

    public List<Employee> getAllEmployees() {
        // TODO: Implement logic to retrieve all Employees.
        // Example: return employeeRepository.findAll();
        return employeeRepository.findAll();
    }

    @Transactional
    public Employee updateEmployee(Long id, EmployeeRequest request) {
        return employeeRepository.findById(id).map(emp-> {emp.setFirstName(request.getFirstName()); 
            emp.setLastName(request.getLastName());
             emp.setPosition(request.getPosition());
              Department dept = null ; 
              if(request.getDepartmentId()!=null)
                { dept = departmentRepository.findById(request.getDepartmentId()).get();
                    emp.setDepartment(dept);
                }
           return employeeRepository.save(emp);
            }).orElseThrow(()->new RuntimeException("Id no exist"));
    }

    @Transactional
    public void deleteEmployee(Long id) {

        employeeRepository.deleteById(id);
        // TODO: Implement logic to delete an Employee by its ID.
        // Example: employeeRepository.deleteById(id);
    }

    // Method to retrieve all employees within a specific department
    public List<Employee> getEmployeesByDepartment(Long departmentId) {

        return employeeRepository.findByDepartmentId(departmentId);
        // TODO: Implement logic to retrieve all employees belonging to a specific department.
    }
}
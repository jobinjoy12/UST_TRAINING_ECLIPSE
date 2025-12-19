package com.example.corporate.repository;

import com.example.corporate.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // TODO: Add a custom query method to find employees by department ID, if direct access through
    // the Department entity's employees set is not sufficient or desired for specific use cases.
    List<Employee> findByDepartmentId(Long departmentId);
}
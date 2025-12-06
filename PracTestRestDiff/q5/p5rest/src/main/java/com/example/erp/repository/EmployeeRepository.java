package com.example.erp.repository;

import com.example.erp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // TODO: Add a JPQL query method here to list employees whose salary exceeds a given minimum value.
    @Query("SELECT e FROM Employee e WHERE e.salary > :minSalary")
    List<Employee> findEmployeesWithSalaryGreaterThan(@Param("minSalary") double minSalary);
}
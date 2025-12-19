package com.example.corporate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "corporate_department")
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    // TODO: Define the One-to-Many relationship with Employee.
    // The foreign key (join column) should be defined on the Employee side with a custom name 'dept_id_fk'.
    // Use mappedBy to indicate the relationship is managed by the 'department' field in the Employee entity.
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Employee> employees = new HashSet<>();

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
        employee.setDepartment(this);
    }

    public void removeEmployee(Employee employee) {
        this.employees.remove(employee);
        employee.setDepartment(null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    
}
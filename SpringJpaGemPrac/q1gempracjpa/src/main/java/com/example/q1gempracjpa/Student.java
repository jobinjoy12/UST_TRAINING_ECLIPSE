package com.example.q1gempracjpa;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ; 

    private String fullName;

    @Column(name = "full_name")
    private String email;

    @OneToMany(mappedBy = "students" , cascade = CascadeType.ALL)
    private List<Enrollment> enrollments;
}

package com.example.q1gempracjpa;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id ;

    private String grade;

    private LocalDate enrollmentDate;

    @ManyToOne
    private Student student ; 
    
    @ManyToOne
    private Course course ; 

}

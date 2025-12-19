package com.example.q1gempracjpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepo extends JpaRepository<Enrollment,Long>{

    
    List<Student> findByEnrollmentsGradeAndTitle(String grade , String title);

}

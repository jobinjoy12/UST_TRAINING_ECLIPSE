package com.example.university.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.university.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByUniversityId(Long universityId);


    List<Course> findByCreditsGreaterThan(int minCredits);

}

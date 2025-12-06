package com.example.university.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.university.entities.Course;
import com.example.university.entities.University;
import com.example.university.repositories.CourseRepository;
import com.example.university.repositories.UniversityRepository;

@RestController
@RequestMapping("/universities")
public class UniversityController {

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    public ResponseEntity<University> createUniversity(@RequestBody University university) {

        University uni = universityRepository.save(university);
        return new ResponseEntity<>(uni,HttpStatus.CREATED);
    }

    @PostMapping("/{universityId}/courses")
    public ResponseEntity<Course> createCourseForUniversity(@PathVariable Long universityId, @RequestBody Course course) {
        
        Optional<University> opt = universityRepository.findById(universityId);
        if(opt.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        opt.get().addCourse(course);
        course.setUniversity(university);
        Course course1 = courseRepository.save(course);
        return new ResponseEntity<>(course1 ,HttpStatus.CREATED); // Placeholder
    }

    @GetMapping("/{universityId}/courses")
    public ResponseEntity<List<Course>> getCoursesByUniversity(@PathVariable Long universityId) {

        Optional<University> opt = universityRepository.findById(universityId);
        if(opt.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Course> listC = courseRepository.findByUniversityId(universityId);
        return new ResponseEntity<>(listC,HttpStatus.CREATED); // Placeholder
    }

   
    @GetMapping("/courses/credits/{minCredits}")
    public ResponseEntity<List<Course>> getCoursesWithMoreThanMinCredits(@PathVariable int minCredits) {
    
        List<Course> lists = courseRepository.findByCreditsGreaterThan(minCredits);
        return new ResponseEntity<>(lists , HttpStatus.OK); // Placeholder
    }
}

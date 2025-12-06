package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.*;            // JPA annotations
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/")
    public String hello() {
        return "Hello, Spring Boot Starter Web is active!";
    }

    // --- JPA Entity ---
    @Entity
    public static class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String course;

        // getters and setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getCourse() { return course; }
        public void setCourse(String course) { this.course = course; }
    }

    // --- Repository ---
    public interface StudentRepository extends JpaRepository<Student, Long> {
        List<Student> findByCourse(String course);
    }

    // --- Service ---
    @Service
    public static class StudentService {
        private final StudentRepository repository;

        public StudentService(StudentRepository repository) {
            this.repository = repository;
        }

        public Student save(Student student) {
            return repository.save(student);
        }

        public List<Student> getAll() {
            return repository.findAll();
        }
    }

    // --- Controller for JPA Demo ---
    @RestController
    @RequestMapping("/students")
    public static class StudentController {
        private final StudentService service;

        public StudentController(StudentService service) {
            this.service = service;
        }

        @PostMapping
        public Student addStudent(@RequestBody Student student) {
            return service.save(student);
        }

        @GetMapping
        public List<Student> getStudents() {
            return service.getAll();
        }
    }
}
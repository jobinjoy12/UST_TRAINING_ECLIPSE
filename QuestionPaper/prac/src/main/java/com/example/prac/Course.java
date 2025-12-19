package com.example.prac;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PreRemove;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(mappedBy = "courses",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Set<Student> students = new HashSet<>();

    public Course(){};
    public Course(String title){
        this.title=title;
    };

    
    public void addStudent(Student student)
    {
        this.students.add(student);
        student.getCourses().add(this);
    }

    public void removeStudent(Student student)
    {
        this.students.remove(student);
        student.getCourses().remove(this);
    }

    @PreRemove
    private void removeCourseFromStudents(){
        for(Student s : this.students){
            s.getCourses().remove(this);
        }
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Set<Student> getStudents() {
        return students;
    }
    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}

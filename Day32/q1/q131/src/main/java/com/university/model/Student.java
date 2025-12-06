package com.university.model;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private int studentId;
    private String name;
    private String major;
    private List<Course> enrolledCourses; 

    public void enrollInCourse(Course course)
    {
        if(!this.getEnrolledCourses().contains(course))
        enrolledCourses.add(course);
          if(!course.getEnrolledStudents().contains(this))
            {course.getEnrolledStudents().add(this);}
    }

    public Student(int studentId, String name, String major) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        this.enrolledCourses = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Student{" +
               "studentId=" + studentId +
               ", name='" + name + '\'' +
               ", major='" + major + '\'' +
               '}';
    }


    public int getStudentId() {
        return studentId;
    }


    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getMajor() {
        return major;
    }


    public void setMajor(String major) {
        this.major = major;
    }


    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }


    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }
}

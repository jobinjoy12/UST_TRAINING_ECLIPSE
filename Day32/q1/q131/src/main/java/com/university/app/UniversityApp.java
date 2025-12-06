package com.university.app;

import com.university.model.Course;
import com.university.model.Instructor;
import com.university.model.Student;

public class UniversityApp {
    public static void main(String[] args) {
        System.out.println("University Management System Application\n");

        Instructor i1 = new Instructor(1, "Jag", "CSE");
        Instructor i2 = new Instructor(2, "Jag2", "IT");

        Student s1 = new Student(11, "Niranj", "IT");
        Student s2 = new Student(12,"Sanjay","CSE");
        Student s3 = new Student(13,"Gokul","IT");

        Course c1 = new Course("111", "IT", 10, i1);
        Course c2 = new Course("112","Java",20,i2);
        Course c3 = new Course("113","Python",15,i1);
        i1.assignCourse(c3);
        i2.assignCourse(c1);

        s1.enrollInCourse(c3);
        s2.enrollInCourse(c1);
        c1.enrollStudent(s3);

        System.out.println("All courses taught By Instructor I1: "+i1.getCoursesTaught());
        System.out.println("All courses taught By Instructor I1: "+i2.getCoursesTaught());

        System.out.println("All students enrolled in course c1: "+c1.getEnrolledStudents());

        System.out.println("All courses a student S1 is enrolled in: "+s1.getEnrolledCourses());
    }
}

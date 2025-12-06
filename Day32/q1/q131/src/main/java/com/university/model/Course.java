package com.university.model;
import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseCode;
    private String title;
    private int credits;
    private Instructor instructor; // TODO: This reference should be set during Course creation or later.
    private List<Student> enrolledStudents; // TODO: Initialize this in the constructor.

    public void enrollStudent(Student student){
        if(!this.getEnrolledStudents().contains(student))
        enrolledStudents.add(student);
        List<Course> list = student.getEnrolledCourses();
        if(!list.contains(this)){
        list.add(this);}
    }

    public Course(String courseCode, String title, int credits, Instructor instructor) {
        this.courseCode = courseCode;
        this.title = title;
        this.credits = credits;
        this.instructor = instructor;
        instructor.assignCourse(this);
        this.enrolledStudents = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Course{" +
               "courseCode='" + courseCode + '\'' +
               ", title='" + title + '\'' +
               ", credits=" + credits +
               '}';
    }


    public String getCourseCode() {
        return courseCode;
    }


    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public int getCredits() {
        return credits;
    }


    public void setCredits(int credits) {
        this.credits = credits;
    }


    public Instructor getInstructor() {
        return instructor;
    }


    public void setInstructor(Instructor instructor) {
        Instructor instr = this.getInstructor();
        List<Course> listC1 = instr.getCoursesTaught();
        if(listC1.contains(this))
        instr.getCoursesTaught().remove(this);
        this.instructor = instructor;
        List<Course> listC = instructor.getCoursesTaught();
        if(!listC.contains(this))
        instructor.getCoursesTaught().add(this);

    }


    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }


    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }
}

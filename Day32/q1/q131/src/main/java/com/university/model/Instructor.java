package com.university.model;
import java.util.ArrayList;
import java.util.List;

public class Instructor {
    private int id;
    private String name;
    private String department;
    private List<Course> coursesTaught; 

    public void assignCourse(Course course)
    {
        if(!this.getCoursesTaught().contains(course))
        coursesTaught.add(course);
         if(course.getInstructor()!=this)
        course.setInstructor(this);
    }


    public Instructor(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.coursesTaught = new ArrayList<>();
    }


    // Optional: toString method for easy printing
    @Override
    public String toString() {
        return "Instructor{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", department='" + department + '\'' +
               '}';
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getDepartment() {
        return department;
    }


    public void setDepartment(String department) {
        this.department = department;
    }


    public List<Course> getCoursesTaught() {
        return coursesTaught;
    }


    public void setCoursesTaught(List<Course> coursesTaught) {
        this.coursesTaught = coursesTaught;
    }
}

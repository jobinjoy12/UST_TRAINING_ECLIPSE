package Question2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Objects;

class Student {
	private String id;
	private String name;

	public Student(String id, String name) {
			this.id = id;
			this.name = name ;// Your code here
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(id, other.id);
	}

	
}

class Course {
	private String code;
	private String title;

	public Course(String code, String title) {
		this.code = code;
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(code, other.code);
	}

	
}

public class CourseEnrollmentSystem {
	private Map<Student, Set<Course>> studentEnrollments;
	private Map<Course, Set<Student>> courseEnrollments;

	public CourseEnrollmentSystem() {
		studentEnrollments = new HashMap<>();
		courseEnrollments = new HashMap<>();
	}

	public boolean enrollStudentInCourse(Student student, Course course) {
	    if (student == null || course == null) return false;

	    boolean addedToStudent = studentEnrollments
	            .computeIfAbsent(student, k -> new HashSet<>())
	            .add(course);

	    
	    boolean addedToCourse = courseEnrollments
	            .computeIfAbsent(course, k -> new HashSet<>())
	            .add(student);

	    return addedToStudent && addedToCourse;
	}

	public Set<Course> getStudentCourses(Student student) {
	   
	    return studentEnrollments.getOrDefault(student, new HashSet<>());
	}

	public Set<Student> getCourseStudents(Course course) {
	    
	    return courseEnrollments.getOrDefault(course, new HashSet<>());
	}
}
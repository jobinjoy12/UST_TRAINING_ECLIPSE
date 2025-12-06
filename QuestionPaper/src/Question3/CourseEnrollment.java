package Question3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student {
	private String studentId;
	private String name;

	public Student(String studentId, String name) {
		this.studentId = studentId;
		this.name = name;
	}

	public String getStudentId() {
		return studentId;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Student student = (Student) obj;
		return studentId.equals(student.studentId);
	}

	@Override
	public int hashCode() {
		return studentId.hashCode();
	}
}

public class Course {
	private String courseId;
	private String title;
	private int capacity;
	private List<Student> enrolledStudents;

	public Course(String courseId, String title, int capacity) {
		this.courseId = courseId;
		this.title = title;
		this.capacity = capacity;
		this.enrolledStudents = new ArrayList<>();
	}

	public String getCourseId() {
		return courseId;
	}

	public String getTitle() {
		return title;
	}

	public int getCapacity() {
		return capacity;
	}

	public boolean enrollStudent(Student student) {
		// Check if course is full and if student is not already enrolled
		if (enrolledStudents.size() < capacity && !enrolledStudents.contains(student)) {
			enrolledStudents.add(student);
			return true;
		}
		return false;
	}

	public List<Student> getEnrolledStudents() {
		// Returns a read-only view of the list
		return Collections.unmodifiableList(enrolledStudents);
	}

	public int getRemainingCapacity() {
		return capacity - enrolledStudents.size();
	}
}
import java.util.Scanner;
class StudentMarks {
      int Mathematics ;
}

public class StudentAnalyzerObject{
	public static void main(String []args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the no of students");
	int noStudents = sc.nextInt();
	
	
	StudentMarks[] students = new StudentMarks[noStudents];
	for(int i=0 ; i<noStudents ; i++) {
		students[i] = new StudentMarks();
		System.out.println("enter the mathetics mark of student"+ i);
		students[i].Mathematics = sc.nextInt();		
	}
	if(students[0].Mathematics > students[1].Mathematics) {
		if(students[0].Mathematics > students[2].Mathematics) {
		System.out.println("Student 0 has highest mark");
	}else{System.out.println("Student 2 has highest mark");}}
	sc.close();}}


public class StudentPerformanceAnalyzer {
	public static void main (String[] args) {
		System.out.println("score = 85, attendancePercentage = 95 , Grade : " + calculateFinalGrade(85,95));
		System.out.println("score = 92, attendancePercentage = 70 , Grade : "+ calculateFinalGrade(92,70));
		System.out.println("score = 55, attendancePercentage = 100 , Grade : "+ calculateFinalGrade(55,100));
	}
	static char calculateFinalGrade(int score, int attendancePercentage) {
		char grade = 'X';
		if(score<0 || score>100 || attendancePercentage<0 || attendancePercentage >100) {
			return 'X';}
		else if(score>=90) {
				 grade ='A';
				
			}else if(score>=80) {
				 grade = 'B';
			}else if(score>=70) {
				 grade = 'C' ;
			}else if(score>=60) {
				 grade = 'D';
			}else { grade = 'F';}
		if(attendancePercentage < 75) {if(grade == 'A') {
			grade = 'B';
			
		}
		else if(grade == 'B') {
			grade = 'C';
		}
		else if(grade == 'C') {
			grade =  'D';
					
		}else if(grade == 'D') {
			grade = 'F';
		}
		}
		if(attendancePercentage == 100) 
			
		{
		if(grade == 'B') {
			grade = 'A';
		}
		else if(grade == 'C') {
			grade =  'B';
					
		}else if(grade == 'D') {
			grade = 'C';
		}}
	
	return grade;}}

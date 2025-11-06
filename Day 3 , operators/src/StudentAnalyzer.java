import java.util.Scanner;
public class StudentAnalyzer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the mark of Mathematics");
		double Mathematics = sc.nextDouble();
		System.out.println("Enter the mark of Science"); 
		double Science = sc.nextDouble();
		System.out.println("Enter the mark of English"); 
		double English = sc.nextDouble();
		sc.close();
		
		double totalScore = (Mathematics + Science + English);
		double averageScore = (totalScore/3);
		char grade = 'F';
		String status = " ";
		if(averageScore >= 60) {status = "Passed";}else {status = "Failed";}
		if((averageScore) >= 90) {grade = 'A';}
		else if(averageScore >= 80 && averageScore <= 89.9) {grade = 'B';}
		else if(averageScore >= 70 && averageScore <= 79.9) {grade = 'C';}
		else if(averageScore >= 60 && averageScore <= 69.9) {grade ='D';}
		else{grade = 'F';}
		
		int studentAttempts = 1 ;
		studentAttempts ++;
		
		double bonusPoints = 5.0 ;
		if(grade == 'A') {bonusPoints += 2.5;}
		
		System.out.println("--- Student Performance Report ---");
		System.out.println("Mathematics Score : "+Mathematics);
		System.out.println("Science Score : "+Science);
		System.out.println("English Score : "+English);
		System.out.println("Total Score : "+totalScore);
		System.out.println("Average Score : "+averageScore);
		System.out.println("Status : "+status);
		System.out.println("Grade : "+grade);
		System.out.println("Student Attempts : "+studentAttempts);
		System.out.println("Bonus Points : "+bonusPoints);
	
		}
		
		}
		
	



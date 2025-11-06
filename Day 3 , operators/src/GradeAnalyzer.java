import java.util.Scanner ;
public class GradeAnalyzer {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a numerical score between 0 and 100");
		int score = sc.nextInt();
		if(score >=90) {
			System.out.println("The grade is : A");
		} else if(score >= 80) {
			System.out.println("The grade is : B");
		}else if(score >= 70 ) {
			System.out.println("The grade is : C");
		} else if (score >= 60) {
			System.out.println("The grade is : D");
			
		}else if(score >= 0 ) {System.out.println("F");}
		else{System.out.println("Invalid score . Please enter the score between 0 and 100");}
		sc.close();
	
	}

}

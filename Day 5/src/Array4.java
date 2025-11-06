
public class Array4 {
	public static void main(String[] args) {
		int[] studentScores = {85, 72, 90, 65, 50, 95, 78, 88, 60, 100};
		int highest=Integer.MIN_VALUE;
		int lowest=Integer.MAX_VALUE;
		int sum =0;
		double avg =0;
		int count =0;
		System.out.println("All Student Scores:");
		for(int i=0;i<studentScores.length;i++) {
			System.out.println(studentScores[i]);
			sum += studentScores[i];
			if(highest<studentScores[i]) {
				highest = studentScores[i];
			}
			if(lowest>studentScores[i]) {
				lowest = studentScores[i];
			}
			if(studentScores[i]>=60) {
				count++;
			}}
		avg = (double)sum/studentScores.length;
		System.out.println();
		System.out.println("Highest Score: "+highest);
		System.out.println("Lowest Score: "+ lowest);
		System.out.println("Average Score: "+ avg);
		System.out.println("No of Passing Students: "+count);
			
		}
	}



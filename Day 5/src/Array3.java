import java.util.Scanner;

public class Array3 {
	public static void main(String[] args) {
		String[] teamNames = {"Mumbai Indians", "Chennai Super Kings", "Royal Challengers Bangalore", "Kolkata Knight Riders", "Sunrisers Hyderabad", "Delhi Capitals", "Punjab Kings", "Rajasthan Royals"};
		int[] teamWins = new int[teamNames.length];
		for(int i =0 ; i<teamWins.length ; i++) {
			System.out.println("Enter the no of wins of the team "+teamNames[i]);
			Scanner sc = new Scanner(System.in);
			teamWins[i] = sc.nextInt();
		}
		for(int j =0;j<teamWins.length;j++) {
			System.out.println(teamNames[j]+" : "+teamWins[j]+" Wins ");
		}
		int[] playerScores = {45 ,82 ,15 , 0 ,67};
		int sum =0;
		for(int k =0;k<playerScores.length;k++) {
			sum += playerScores[k];
		}
	}
}
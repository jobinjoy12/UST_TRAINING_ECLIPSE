
public class Arrays2 {
	public static void main(String[] args) {
		int[][] seasonMatchScores = {{180}, {165}, {205}, {190}};
		double sum = 0;
		double avg = 0;
		for(int i =0; i<seasonMatchScores.length ; i++) {
			for(int j=0;j<seasonMatchScores[i].length;j++) {
			   	sum += seasonMatchScores[i][j];}
			}avg = sum/seasonMatchScores.length;
			System.out.println("--- Season Performance Analysis ---");
		System.out.println("Average score over 4 matches : "+avg);
			System.out.println("Total runs across 4 matches :" +sum);
	}
}


public class Array1 {
	public static void main(String[] args) {
		int[] matchScores = {65,42,10,88,30,5};
		int totalScore =0;
		for(int num : matchScores) {
			totalScore += num;
		}System.out.println("--- Single Match Analysis ---");
		System.out.println("Total runs in the match :"+totalScore);
		int max = 0;
		for(int nm : matchScores) {
			if(max<nm) {
				max = nm;
			}
		}System.out.println("Highest individual score : "+max);
	}
}

import java.util.HashSet;
import java.util.Set;

public class code {
	public static void main(String[] args){
		int length = 5;
		int noTowers = 3;
		int[][] coordinates = {{2,2},{0,1},{4,1}};
		int[][]	array = new int[length][length];
		Set<String> set = new HashSet<>();
		for(int i=0;i<length;i++) {
			for(int j =0;j<length ; j++) {
				array[i][j] = 0;
			}
		}
		for(int i =0;i<coordinates.length;i++) {
			int x = coordinates[i][0];
			int y = coordinates[i][1];
		for( int j = x-1 ;j<=x+1;j++) {
			for(int k=y-1;k<= y+1;k++) {
				if(j>=0 && j<length && k>=0 && k<length) {
					set.add("["+j+","+k+"]");
				}
			}
		}
	}
	int yescount = set.size();
	int total = length*length;
	int uncovered = total - yescount;
	System.out.println(total);
	System.out.println(yescount);
	System.out.println(uncovered);
	}
}

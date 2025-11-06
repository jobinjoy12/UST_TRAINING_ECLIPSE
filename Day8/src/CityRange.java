import java.util.HashSet;
import java.util.Set;
import java.util.*;

public class CityRange {
	public static void main(String[] args) {
		int lengthCity = 5 ;
		int noTowers = 3;
		int[][] coordinates = {{2,2},{0,1},{4,1}};
		// max is {0,0} , {n-1,n-1};
		int count = 0;
		int[][] arr = new int[lengthCity][lengthCity];
		for(int i =0 ; i<lengthCity;i++) {
			for(int j =0 ;j<lengthCity;j++) {
				arr[i][j] = 0;
				System.out.println(++count);
			}
		}
		count =0;
		int x = 0;
		int y = 0;
		for(int k =0;k<coordinates.length ;k++) {
			x = coordinates[k][0];
			y = coordinates[k][1];
		
		for(int i = x-1;i<=x+1;i++) {
			for(int j = y-1;j<=y+1;j++) {
				if(i>=0 && i<lengthCity && j>=0 && j<lengthCity) {
					arr[i][j]=1;
				}
			}
		}}
		for(int i =0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(arr[i][j]==0) {
					count++;
				}
			}
		System.out.println(count);
	}
	}
}

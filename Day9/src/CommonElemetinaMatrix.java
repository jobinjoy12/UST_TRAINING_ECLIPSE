import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommonElemetinaMatrix {
	public static void main(String[] args) {
		int[][] matrix = {
	            {1, 2, 3, 5},
	            {2, 4, 5, 8},
	            {3, 5, 7, 9},
	            {1, 3, 5, 7}
	        };
		Set<Integer> set = new HashSet<Integer>();
		for(int i =0;i<matrix.length;i++) 
		{
				set.add(matrix[0][i]);
		}
		int index = 0;
		int count=0;
		boolean common = false;
		boolean found = false;
		int[] arr = new int[matrix.length*matrix.length];
		System.out.println(set);
		outer1: for(int num : set) 
		{
		common =true;
		
			outer2: for(int i=1;i<matrix.length;i++)
			{ found = false;
				for(int j=0;j<matrix[i].length;j++) 
				{
					if(num == matrix[i][j]) 
					{	
						found=true;
						break;
				}
			}if(!found) {
				common = false;
				break;
			}
		}if(common) {
			System.out.println(num);
		}
		
	}
}}
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class array1 {
	public static void main(String[] args) {
		int n = 5 ;
		int[] ar = {35, 30, 7 ,6 ,5};
		int max = Integer.MIN_VALUE;
		Set<Integer> set = new HashSet<>();
		for(int i =0;i<n;i++) {
			set.add(ar[i]);
			}
		Arrays.sort(ar);
		for(int i =0;i<n;i++) {
			if(set.contains(ar[i])){
				System.out.println(ar[i]);
				break;
			}
		
			
		}
	}

}

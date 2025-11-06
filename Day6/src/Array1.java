import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Array1 {
	public static void main(String[] args) {
		int[] ar = {4 ,8, 2, 5,9};
		int N =  5;
		int n = 3;
		int min = Integer.MAX_VALUE;
		Set<Integer> set = new HashSet<>();
		int[] ar1 = Arrays.copyOf(ar, N);
		Arrays.sort(ar);
		for(int i =0 ; i<n ; i++) {
				set.add(ar[i]);
			}
		for(int i = 0 ; i<N;i++) {
			if(set.contains(ar1[i])) {
			System.out.println(ar1[i]);}
		}
	}
}

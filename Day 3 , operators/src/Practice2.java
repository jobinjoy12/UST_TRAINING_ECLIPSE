import java.util.*;
public class Practice2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = {1,2,3,4,5};
		int sum =0;
		int sum1 = 0;
		for(int i =0;i<arr.length;i++) {
			sum += arr[i];
			if(sum > n ) {
				sum -= arr[i];
				System.out.println(sum +" , "+ (i));
			}
		}
	}

}

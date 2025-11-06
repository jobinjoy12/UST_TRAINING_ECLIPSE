import java.util.Arrays;

public class Selection {
	public static void main(String[] args) {
		int[] arr= {9,8,3,10,11};
		int n = arr.length;
		for(int i =0;i<n-1;i++) {
			int min = i;
			for(int j =i+1;j<n;j++) {
				if(arr[min] > arr[j]) {
					min = j;
				}
			}int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}System.out.println(Arrays.toString(arr));
	}

}

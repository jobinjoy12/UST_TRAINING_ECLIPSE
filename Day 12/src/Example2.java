import java.awt.List;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Example2 {
	public static void main(String[] args) {
	int N = 5;
	int[] arr = {4,8,2,5,9};
	int n = 3;
	Set<Integer> num = new LinkedHashSet<Integer>();
	for(int nm : arr)
	{
		num.add(nm);
	}
	Arrays.sort(arr);
	System.out.println(Arrays.toString(arr));
	int[] smal = new int[n];
	for(int i =0;i<n;i++)
	{
		smal[i] = arr[i];
		if(num.contains(smal[i])) {
			
		}

	}
}}

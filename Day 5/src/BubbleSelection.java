import java.util.Arrays;

public class BubbleSelection {
	public static void main(String[] args) {
		int[] data = {5, 1, 4, 2, 8};
		int[] data2 = {5, 1, 4, 2, 8};
		System.out.println("Before :"+Arrays.toString(data));
		System.out.println("Before :"+Arrays.toString(data2));
		System.out.println(Arrays.toString(bubbleSort(data)));
		System.out.println(Arrays.toString(selectionSort(data2)));
		int[] data3 = {1,9,3,2,5};
		int[] data4 = {1,9,3,2,5};
		System.out.println("Before :" + Arrays.toString(data3));
		System.out.println("Before :" + Arrays.toString(data4));
		System.out.println(Arrays.toString(bubbleSort(data3)));
		System.out.println(Arrays.toString(selectionSort(data4)));
	}
	public static int[] bubbleSort(int[] arr)
	{
		int n = arr.length;
		for(int i =0;i <n-1;i++)
		{
			for(int j =0 ; j<n-i-1;j++) 
			{
				if(arr[j] > arr[j+1]) 
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;	
				}
			}
		}
		
	return arr;}
	
	public static int[] selectionSort(int[] arr) {
		int n = arr.length;
		for(int i =0;i<n-1;i++) 
		{
			int min = i;
			for(int j =i+1;j<n;j++) 
			{
				if(arr[min] > arr[j]) 
				{
					min = j;
				}
			}
		int temp = arr[min];
		arr[min] = arr[i];
		arr[i] = temp;}
	return arr;}
}

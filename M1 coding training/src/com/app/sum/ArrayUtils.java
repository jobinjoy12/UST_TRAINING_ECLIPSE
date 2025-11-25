package com.app.sum;

public class ArrayUtils {
	public static int findLargest(int[] numbers)
	{
		int max = numbers[0];
		for(int i =0;i<numbers.length;i++)
		{
			if(max < numbers[i])
			{
				max = numbers[i];
			}
		}return max;
	}
	public static void main(String[] args) {
		int[] numbers = {7};
		System.out.println(findLargest(numbers));
		
	}
}

package com.java.gener;

public class ArrayUtils {
	public static <T> void printArray(T[] array)
	{
		for(T ar : array)//For each loop for traversing through each element in the array.
		{
			System.out.print(ar+" ");
		}
	}
}

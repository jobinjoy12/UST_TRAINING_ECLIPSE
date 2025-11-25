package com.app.sum;

public class StringManipulator {
	public static String reverseString(String str) {
		char[] arr = str.toCharArray();
		char[] newarr = new char[arr.length];
		for(int i =0;i<arr.length;i++)
		{	
			newarr[i] =  arr[arr.length-1-i];
		}
		return String.valueOf(newarr);
	}
	
		public static void main(String[] args) {
			System.out.println(reverseString("hello"));
		}
}

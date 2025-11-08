package com.mycompany.utilities;

public class StringManipulator {
	public static String reverseString(String str) {
		String reversed = new StringBuilder(str).reverse().toString();
		return reversed;
	}
	public static boolean isPalindrome(String str) {
		String reversed = new StringBuilder(str).reverse().toString();
		if(reversed.equalsIgnoreCase(str)){
			return true;
		}return false;
	}
}

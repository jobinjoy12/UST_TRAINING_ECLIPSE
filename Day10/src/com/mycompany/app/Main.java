package com.mycompany.app;

import com.mycompany.utilities.StringManipulator;
public class Main {
	public static void main(String[] args) {
		String str = "hello";
		String str1 = "madam";
		String str2 = "world";
		System.out.println("Before reversing String : "+str);
		System.out.println("After reversing String : "+StringManipulator.reverseString(str));
		System.out.println("Palindrome Checking String 1 : "+str1);
		System.out.println("Palindrome : "+StringManipulator.isPalindrome(str1));
		System.out.println("Palindrome Checking String 2 : "+str2);
		System.out.println("Palindrome : "+StringManipulator.isPalindrome(str2));
		
		
	}
}

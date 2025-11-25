package com.app.sum;

public class NumberChecker {
	public static String checkEvenOdd(int number)
	{
		if(number%2==0)
		{
			return "Even";
		
		}else {
			return "Odd";
		}
	}
	public static void main(String[] args) {
		System.out.println(checkEvenOdd(4));
		System.out.println(checkEvenOdd(7));
		System.out.println(checkEvenOdd(0));
	}
}

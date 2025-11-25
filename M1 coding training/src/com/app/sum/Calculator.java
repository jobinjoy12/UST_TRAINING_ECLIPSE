package com.app.sum;

public class Calculator {
	public static int sum(int a, int b)
	{
		int sum = a + b ;
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(sum(5,3));
		System.out.println(sum(-1,10));
		System.out.println(sum(0,0));

	}
}


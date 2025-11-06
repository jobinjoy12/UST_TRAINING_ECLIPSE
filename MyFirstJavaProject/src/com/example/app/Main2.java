package com.example.app;
import java.util.Scanner;

public class Main2 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first number = ");
		int input = sc.nextInt();
		System.out.println("Enter the second number = ");
		int input2 = sc.nextInt();
		int sum = input + input2;
		
		System.out.println("The sum of "+input+" and "+input2+" is "+sum);
	}

}

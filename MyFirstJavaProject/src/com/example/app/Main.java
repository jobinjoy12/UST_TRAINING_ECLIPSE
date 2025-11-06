package com.example.app;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) { 
		if(args.length > 0) {
			String a = args[0];
			String b = args[1];
			int sum = Integer.parseInt(a) + Integer.parseInt(b) ;
			System.out.println("The sum of "+ a +" and "+ b+ " is "+sum);
		}
		else{
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter the first number = ");
				int input = sc.nextInt();
				System.out.println("Enter the second number = ");
				int input2 = sc.nextInt();
				int sum = input + input2;
				
				System.out.println("The sum of "+input+" and "+input2+" is "+sum);
			}

		}

	}



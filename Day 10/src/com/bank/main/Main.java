package com.bank.main;
import com.bank.account.*;

public class Main {
	public static void main(String[] agrs) {
		BankAccount myAccount = new BankAccount("82132",1000);
		BankAccount myAccount2 = new BankAccount("82132",-1000);
		myAccount.balance = -100; //Since balance is a private access modifier we wont be able to modify it directly.
		System.out.println(myAccount.getAccountNumber());
		System.out.println(myAccount.getBalance());
		myAccount.deposit(1000);
		System.out.println(myAccount.getBalance());
		myAccount.deposit(-1000);
		System.out.println(myAccount.getBalance());
		System.out.println(myAccount.withdraw(1000));
		System.out.println(myAccount.getBalance());
		System.out.println(myAccount.withdraw(-1000));
		System.out.println(myAccount.getBalance());
		System.out.println(myAccount.withdraw(10000));
		System.out.println(myAccount.getBalance());
	}
}

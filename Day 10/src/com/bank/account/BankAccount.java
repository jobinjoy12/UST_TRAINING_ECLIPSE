package com.bank.account;

public class BankAccount {
	private String accountNumber;
	private double balance;
	
	public BankAccount(String accountNumber, double initialBalance) {
		this.accountNumber = accountNumber;
		if(initialBalance < 0) {
		this.balance = 0;
		System.out.println("Warning : Balance cannot be negative so balanace is set to 0");
		}else{
            this.balance = initialBalance;
        }
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	private void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		if(amount <= 0) {
			System.out.println("Error amount is negative value");
		}else {
		setBalance(balance += amount);}
	}
	
	public boolean withdraw(double amount){
		if(amount <= 0) 
		{
			System.out.println("Error amount is negative value");
			return false;
		}else if(amount > balance)
		{
			System.out.println("Insufficient funds");
			return false;
		}else {
			setBalance(balance -= amount);
			return true;
		}
	}}



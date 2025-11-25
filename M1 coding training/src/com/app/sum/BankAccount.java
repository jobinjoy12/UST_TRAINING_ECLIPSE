package com.app.sum;

public class BankAccount {
	private String accountHolderName;
	private String accountHolderNumber;
	private double balance ;
	
	public BankAccount(String accountNumber , String accountHolderName , double balance)
	{
		this.accountHolderNumber = accountNumber ;
		this.accountHolderName = accountHolderName;
		this.balance = balance; 
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public String getAccountHolderNumber() {
		return accountHolderNumber;
	}

	

	public double getBalance() {
		return balance;
	}

	public boolean deposit(double amount)
	{
		if(amount >0)
		{
			balance += amount;
			return true;
		}
		return false;
	}
	
	public boolean withdraw(double amount)
	{
		if(amount >0) 
		{
		if(amount <= balance)
		{
			balance -= amount ;
			return true;
		}
		
	}return false ;}
	
	
}
	
	


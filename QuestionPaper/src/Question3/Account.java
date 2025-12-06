package Question3;

import java.util.ArrayList;
import java.util.List;

class Account {
	private String accountNumber;
	private String accountHolderName;
	private double balance;

	public Account(String accountNumber, String accountHolderName, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		if(amount < 0) {
			System.out.println("not possible");
		}
		else {
			balance += amount;
		}
	}

	public void withdraw(double amount) {
		// Your code here
		if(amount <0)
			System.out.println("not possible");
		if(balance > amount)
		balance -= amount;
	}
}

public class Bank {
	private List<Account> accounts;

	public Bank() {
		// Your code here
		this.accounts = new ArrayList<>();
	}

	public void addAccount(Account account) {
		// Your code here
		accounts.add(account);
	}

	public Account findAccount(String accountNumber) {
		// Your code here
		if(accountNumber == null)
				return null;
		else {
			for(Account acc : accounts) {
				if(acc.getAccountNumber()==accountNumber)
				{
					return acc;
				}
			}
		}
	}

	public void transferFunds(String fromAccountNum, String toAccountNum, double amount) {
		Account from = findAccount(fromAccountNum);
		Account to = findAccount(toAccountNum);
		from.withdraw(amount);
		to.deposit(amount);
	}
}

public class BankAccount {
	String accountNumber;
	String accountHolderName;
	double balance;
	
	public BankAccount(String accountNumber, String accountHolderName) {
		this.accountNumber=accountNumber;
		this.accountHolderName =  accountHolderName;
		balance = 0.0;
	}
	public void deposit(double amount) {
		if(amount > 0) {
		this.balance += amount;}
		
	}
	public void withdraw(double amount) {
		if(amount >0) {
		if(this.balance >= amount) {
			this.balance -= amount;
			
		}else {System.out.println("insufficient funds");}
	}}
	public void displayAccountDetails() {
		System.out.println("Account Number : "+this.accountNumber+", Account Holder Name " + this.accountHolderName+", Balance: "+this.balance);
	}
}

public class Main{
	public static void main(String[] args) {
		BankAccount account1 = new BankAccount("12345", "Alice Smith");
		account1.deposit(500.0);
		account1.withdraw(150.0);
		account1.displayAccountDetails();

		BankAccount account2 = new BankAccount("67890", "Bob Johnson");
		account2.deposit(1000.0);
		account2.withdraw(1200.0); // Should show insufficient funds
		account2.displayAccountDetails();

		
		
	}
}

public class BankApp {
	public static void main(String[] args) {
		BankAccount account1 = new BankAccount("1234","Jobin",1000.00);
        System.out.println(account1.getAccountHolderName());
		System.out.println(account1.getAccountNumber());
		System.out.println(account1.getBalance());
		account1.deposit(1000);
		System.out.println(account1.getBalance());
		account1.deposit(-1000);
		System.out.println(account1.getBalance());
		account1.deposit(11000);
		System.out.println(account1.getBalance());
		account1.withdraw(1000);
		System.out.println(account1.getBalance());
		account1.withdraw(-1000);
		System.out.println(account1.getBalance());
		account1.withdraw(121000);
		System.out.println(account1.getBalance());
		
		System.out.println(account1.getAccountHolderName());
		System.out.println(account1.getAccountNumber());
		System.out.println(account1.getBalance());
		
		BankAccount account2 = new BankAccount("4313","Jibin",909.00);
		System.out.println(account2.getAccountHolderName());
		System.out.println(account2.getAccountNumber());
		System.out.println(account2.getBalance());
        account2.deposit(1000);
		System.out.println(account2.getBalance());
		account2.deposit(-1000);
		System.out.println(account2.getBalance());
		account2.deposit(11000);
		System.out.println(account2.getBalance());
		account2.withdraw(1000);
		System.out.println(account2.getBalance());
		account2.withdraw(-1000);
		System.out.println(account2.getBalance());
		account2.withdraw(121000);
		System.out.println(account2.getBalance());
		
		System.out.println(account2.getAccountHolderName());
		System.out.println(account2.getAccountNumber());
		System.out.println(account2.getBalance());
		//account2.balance=1000; 
        System.out.println("i have observed that it wont work since balance field is private. you can only access it with getter and setter methods.This compilation error Exception in thread "main" java.lang.Error: Unresolved compilation problem: The field BankAccount.balance is not visible at BankApp.main(BankApp.java:26) occurs because balance is a private field . This shows encapsulation as it denies the user from indirecly accessing from outside the class.");
    }
}

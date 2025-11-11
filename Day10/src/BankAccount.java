
public class BankAccount {
	private String accountNumber ;
	private String accountHolderName;
	private double balance ;
	
	public BankAccount(String accountNumb , String accountHolderName , double initialBalance) {
		this.accountNumber = accountNumb;
		this.accountHolderName = accountHolderName;
		if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }}
		
		public String getAccountNumber(){
				return accountNumber;
		}
		
		public String getAccountHolderName() {
			return accountHolderName;
		}
		
		public double getBalance() {
			return balance;
		}
		public void deposit(double amount) {
			if(amount>0) {
				balance += amount;
				System.out.println("New Balance: "+balance);
			}
			else
			{
				System.out.println("Deposit amount must be positive.");
			}}
		
		public void withdraw(double amount) {
			if(amount>0)
			{
				if(balance>=amount)
				{
					balance -=amount;
					System.out.println("New Balance :"+balance);
				}
				else {
					System.out.println("Insufficient funds");
				}
			}	
			else {
				System.out.println("Withdrawal amount must be positive.");
			}
		}
		
	}


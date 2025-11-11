import java.util.Scanner ;
public class Practice{
	public static void main(String[] args) {
		double balance = 1000.0;
		System.out.println("Enter your option : ");
		Scanner sc = new Scanner(System.in);
		int opt = 0;
		while(opt != 4) {
			System.out.println(" 1. Check Balance\r\n"
					+ " 2. Deposit\r\n"
					+ " 3. Withdraw\r\n"
					+ " 4. Exit");
			opt = sc.nextInt();
			switch(opt) {
			case 1:
				System.out.println("Current Balance = "+balance);
				break;
			case 2:
				System.out.println("Enter the amount you want to deposit :");
				double deposit = sc.nextDouble();
				balance += deposit;
				System.out.println("Amount "+deposit+" has been Deposited , Balance : "+balance);
				break;
			
			case 3:
				System.out.println("Enter the amount to withdraw");
				double withdraw = sc.nextDouble();
				if(withdraw <= balance) {
					balance -= withdraw;
					System.out.println("Succesfful , New Balance : "+balance);}
				else {
					System.out.println("Insufficient Balance");
				}
				break;
			case 4:
				System.out.println("Thankyou for using our ATM");
				break;
			default : System.out.println("Invalid value , Enter option (1-4)");
				
			}
		}
		
	sc.close();}

}

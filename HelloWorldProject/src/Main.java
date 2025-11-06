import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		if(input<=3) {System.out.println("Not a prime number");
		return;}
		for(int i=3;i<=Math.sqrt(input);i++) {
			if( input%i==0) {System.out.println("not a Prime num");
			return;}
		}
		System.out.println("Prime");
		}
		

	}



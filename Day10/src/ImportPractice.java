import java.util.Date;
import java.util.Scanner;

public class ImportPractice {
	public static void main(String[] args) {
		System.out.println("Enter your name: ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Date now = new Date();
		System.out.println("Hell0, "+str+"! Today's date and time is: "+now);
		
	}
}

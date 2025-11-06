import java.util.Scanner;
public class Practice1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dice1 = sc.nextInt();
		int dice2 = sc.nextInt();
		int points = 0;
		if(dice1 > 6 || dice2 > 6 || dice1 <0 || dice2 < 0) {
			System.out.println("Invalid input");
		}
		if((dice1 + dice2)>8) {
			int result = 2*(8-(dice1 + dice2)) ;
			points = Math.abs(result);
		}else{points = 8-(dice1 + dice2);} 
			
		
		System.out.println(points);
	}
}
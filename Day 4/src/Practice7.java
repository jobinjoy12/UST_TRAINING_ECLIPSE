import java.util.*;
public class Practice7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().trim();
		int count4 = 0 ;
		int count7 = 0;
		int sum = 0 ;
		boolean valid = true ;
		for(char ch : str.toCharArray()) {
			if(ch == '4') {
				count4++;
				sum += (int)ch;
			}else if(ch == '7') {
				count7++;
				sum += (int)ch;
			}else{valid =false;}
		}
		if((count4 > count7)&&(sum%2 !=0)) {
			valid = true;
		}else {valid = false;}
	System.out.println(valid);}
	

}

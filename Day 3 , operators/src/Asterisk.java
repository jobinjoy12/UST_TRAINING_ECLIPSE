
public class Asterisk {
	public static void main(String[] args) {
		int rows = 5;
		for(int i=1;i<=rows;i++) {
			for(int k = 0 ; k<rows-i;k++) {
				System.out.print(" ");
			}
			for(int j=1 ;j<i*2;j++) {
				
				System.out.print("*");
				
			}System.out.println();
		
		
	}

}}
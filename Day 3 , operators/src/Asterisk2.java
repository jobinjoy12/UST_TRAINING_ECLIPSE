public class Asterisk2{
	public static void main(String[] args) {
		int n = 3;
		//top half;
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 0 ; j<n-i;j++) {
				System.out.print(" ");
				
			}
			for(int k = 1 ; k<=(2*i-1);k++) {
				System.out.print("*");
				
			}System.out.println("");
			
		}
		for(int i =1 ; i<=n-1 ; i++) {
			for(int j = 1 ; j<=i ; j++) {
				System.out.print(" ");
				
			}
			for(int k = 4 ;  k>(2*i-1);k--) {
				System.out.print("*");
			}System.out.println("");
			
		}
	}
}
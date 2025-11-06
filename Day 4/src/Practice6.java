
public class Practice6 {
	public static void main(String[] args) {
		if(palindrome(103)&&addnum(103)) {
			System.out.println("Lucky Winner");
		}
	}
		public static boolean palindrome(int num){
			int t =0 ;
			int n = num;
			while(n > 0) {
				int f = n % 10 ;
				t = t * 10 + f;
			    n = n / 10; 
			}
			if (t == num){return true;}
			else {return false;}
		}
		public static boolean addnum(int num) {
			int sum =0 ;
			while(num > 0) {
			int temp = num % 10;
			sum += temp ;
			num = num / 10 ;
			}
			if(sum%2 == 0)return true;
			else return false;
					
			
		}
	}



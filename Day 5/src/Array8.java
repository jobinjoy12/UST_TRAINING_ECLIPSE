import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
class prime{
		public static boolean findprime(int n){
			if(n <=1) {
				return false;
			}else {
			for(int i=2;i<=Math.sqrt(n);i++) {
				if(n%i==0) {
					return false;
				}}
		
			}
		return true;}}

public class Array8 {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		set.add(2);
		set.add(3);
		set.add(5);
		set.add(7);
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the range");
		int x = sc.nextInt();
		int y = sc.nextInt();
		sc.close();
		int a = Math.abs((x-y));
		for(int i=x+1;i<y;i++) {
		if((prime.findprime(i))) {
			boolean alldigprime = false ;
			int num = i;
			int temp =i;
			while(num>0) {
			int j =num%10;
			 num = num/10;
			
				if(set.contains(j))
						{
							alldigprime = true ;
						}else{alldigprime = false;break;}}if(alldigprime == true) {
							list.add(temp);
						}}
			
			
		
		System.out.println(list);}
			
		}}
	



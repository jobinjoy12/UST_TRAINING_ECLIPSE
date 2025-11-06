import java.util.Scanner;

public class Array6 {
	public static void main(String[] args) {
		System.out.println("enter the no of elements");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ar = new int[n];
		int larg = -1;
		for(int i =0;i<n;i++) {
			ar[i] = sc.nextInt();
		}for(int i =0;i<n;i++) {
			for(int k=i+1;k<n;k++) {
			if((ar[i] * ar[k])>larg) {
				for(int j = 0 ; j<n;j++) {
					if((ar[i]*ar[k])==ar[j]) {
						larg = (ar[i]*ar[k]);
					}
				}
				
			}
	}}
		System.out.println(larg);}}


public class PrecedenceDemo {
	public static void main(String[] args) {
		int result1 = 10 + 5 * 2 - 3;
		System.out.println("10 + 5 * 2 - 3 = "+result1);//i got the answer on paper as 17;
		boolean result2 = (15>10) && (8<12) || (6==7) ; //i got the answer on paper as false;
		System.out.println("(15>10) && (8<12) || (6==7) = "+result2);
		double result3 = 20 / 4 + 3.0 * 2 - 1; //i got it as 10;
		System.out.println("20 / 4 + 3.0 * 2 - 1 = "+result3);
		int result4 = 10 % 3 + 4 * 2 - 1; //i got the answer as 8;
		System.out.println("10 % 3 + 4 * 2 - 1 = "+result4);
		int a =5;int b =3; int result5 = a++ * 2 + --b; //i got the answer as 10;
		System.out.println("a++ * 2 + --b "+result5);
		boolean result6 = !(5 < 3) && (10 >= 10); // i got the answer as true ;
		System.out.println("!(5 < 3) && (10 >= 10) = "+result6);
	}

}

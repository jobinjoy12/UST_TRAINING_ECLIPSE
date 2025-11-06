
public class RecursiveMethods {
	public static void main(String[] args) {
		
		System.out.println("Factorial of 5: " +factorial(5));
		System.out.println("Fibonacci of 10:"+fibonacci(10));
		try {
		System.out.println("Factorial of -3: " +factorial(-3));
		}catch(IllegalArgumentException e) {
			System.out.println("Error calculating factorial: "+e.getMessage());
		}
		
		try {
		System.out.println("Fibonacci of -2:"+fibonacci(-2));
	} catch(IllegalArgumentException e) {
		System.out.println("Error calculating factorial: "+e.getMessage());
	}
		
	}
	public static long factorial(int n ) {
		
		if(n<0) {
			throw new IllegalArgumentException("Negative number is not valid in factorial");
		}
		if(n == 0 || n ==1) {
			return 1;
		}
		return n*factorial(n-1);
		
	}
	
	public static long fibonacci(int n) {
		if(n<0) {
			throw new IllegalArgumentException("Negative number is not valid in fibonacci");
		}
		if(n == 0) {return 0;}
		else if(n == 1) {return 1;}
		return fibonacci(n-1) + fibonacci(n-2);
		
	}
	
}

import java.util.Arrays;

public class ArrayClasses {
	public static void main(String[] args) {
		double[] productPrices = {12.99, 5.50, 89.95, 3.25, 50.00, 12.99};
		Arrays.sort(productPrices);
		System.out.println(Arrays.toString(productPrices));
		int a = Arrays.binarySearch(productPrices,50.00);
		if(a >= 0)
		{
		System.out.println("Binary Search found at index"+ a);
		}else 
		{
			System.out.println("Binary Search Failed");
		}
		double[] promotionalPrices = Arrays.copyOf(productPrices,productPrices.length);
		promotionalPrices[0] = 9.99;
		if(Arrays.equals(productPrices, promotionalPrices)) {
			System.out.println("Both the arrays are equal");
		}else{System.out.println("Arrays are not equal");}
		promotionalPrices = Arrays.copyOf(productPrices,productPrices.length);
		if(Arrays.equals(productPrices, promotionalPrices)) {
			System.out.println("Both the arrays are equal");
		}else{System.out.println("Arrays are not equal");}
	}}
import org.junit.jupiter.api.Assertions;

public class StringUtility {
	public static String reverseString(String input)
	{
		//preconditionAssertion
		assert input !=null : "Input string cannot be null";
		if(input.isEmpty())
		{
			return "";
		}
		if(input.length() == 1 )
		{
			return input;
		}
		StringBuilder sb = new StringBuilder(input);//stringbuulder for reversing
		String reversed = sb.reverse().toString();
		
		//postcondition Assertion
		
		assert input.length()==reversed.length() : "The length of the input and reversed string must be equal";
		
		//postcondition assertion
		String input4 = new StringBuilder(reversed).reverse().toString();
		assert input.equals(input4) : "This should be equal";
			
		return reversed;
	}
}


public class StringUtils {
	public static String reverseString(String input)
	{
		if(input == null|| input.isEmpty())//hanlind null
		{
			return null;
		}
		if(input.length() == 1 )
		{
			return input;
		}
		StringBuilder sb = new StringBuilder(input);//stringbuulder for reversing
		String reversed = sb.reverse().toString();
		return reversed;
	}
	public static boolean isPalindrome(String input)
	{
		if(input == null)//hanlind null
		{
			return false;
		}
		if(input.isEmpty())
		{
			return true;
		}
		if(input.length() == 1 )
		{
			return true;
		}
		StringBuilder input2 = new StringBuilder(input);
		for(char c : input.toCharArray())
		{
		
			if(Character.isLetterOrDigit(c))
			{
				input2.append(c);
			}
		}
		String input3 = input2.toString();
		StringBuilder sb = new StringBuilder(input3);//stringbuulder for reversing
		String reversed = sb.reverse().toString();
		return input3.toLowerCase().trim()==reversed.toLowerCase().trim();
	}
}


public class Methods {
	public static void main(String[] args) {
		printWelcomeMessage("John");
		System.out.println(generateFormattedMessage("Alert","System Offline"));
		System.out.println(addTwoMethod(9,10));
		
	}
	public static void printWelcomeMessage(String str)
	{
		System.out.println("Welcome, "+str+"!");
	}
	public static String generateFormattedMessage(String prefix, String content) 
	{
		return prefix+" : "+content;
	}
	public static int addTwoMethod(int a , int b)
	{
		int sum = a + b;
		return sum;
	}
}

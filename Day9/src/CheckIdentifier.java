
public class CheckIdentifier {
	public static void main(String[] args) {
		String str = "1qq-q";
		char a = str.charAt(0);
		if(!Character.isLetter(a)){
			System.out.println("Error1");
		}
		for(int i = 1;i<str.length();i++) 
		{
			char b = str.charAt(i);
			
		if(!(Character.isLetter(b)||Character.isDigit(b)||b=='_')) {
			System.out.println("Error2");
			break;
		}}
}
}
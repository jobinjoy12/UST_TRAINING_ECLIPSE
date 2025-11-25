
public class Example {
	public static void main(String[] args)
	{
		String inp = "1X0";
		int y = 6;
		char c = 0;
		for(int i =0;i<9;i++)
		{
		String news = inp.replace('X',(char)('0' + i));
		int b = Integer.parseInt(news);
		if(b%6==0) {
			System.out.println(b);
		}
		}
	}	
}
	


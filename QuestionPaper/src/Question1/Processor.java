package Question1;

import java.io.IOException;

class Processor {
	public Object process() throws Exception{
		return new Processor();
	}
}

class StringProcessor extends Processor{
	@Override
	public String process() throws IOException{
		return  "StringProcessor()";
	}
}

public class Main
{	
	public static void main(String[] args) {
		Processor p = new Processor();
		try {
			p.process();
		}catch(Exception e) {System.out.println(e.getMessage());}
		StringProcessor sp = new StringProcessor();
		try {
			sp.process();
		}catch(IOException e) {System.out.println(e.getMessage());}
		catch(Exception e) {System.out.println(e.getMessage());}
		}
}


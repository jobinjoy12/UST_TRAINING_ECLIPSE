package Thursday1;

import java.util.HashMap;
import java.util.Map;

class FactHash{
	public int factorial(int num) {
		if(num == 0 ) {
			return 0;
		}
		else if(num == 1 )
		{
			return 1;
		}
		else {
			return num*factorial(num-1);
		}
		
	}
}
public class Main{
	public static void main(String[] args) {
		FactHash f = new FactHash();
		System.out.println(f.factorial(5));
		Map<Integer,Integer> map = new HashMap<>();
		map.put(5,f.factorial(5));
		for(int i =1;i<5;i++) {
			map.put(i, f.factorial(i));
		}
		for(Map.Entry<Integer,Integer> e : map.entrySet()) {
			System.out.println(e.getKey()+" : "+e.getValue());
		}
	}
}

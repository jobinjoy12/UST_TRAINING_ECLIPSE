
public class LoopExploration {
	public static void main(String[] args) {
		for(int i =10;i>0;i--) {
			System.out.println(i);
		}System.out.println("Blast Off!");
		int i =1;
		int sum =0;
	while(i<20) {
		if(i % 2 == 0) {
			sum += i ;
			
		}
		i++;
		
		
		
	}System.out.println("Sum of even numbers between (1-20) : "+sum);
	for(i=1;i<6;i++) {
		System.out.println("Multiplication Table for "+ i);
		for(int j =1 ;j<11;j++) {
			System.out.println(j+" * "+i+" = "+(j*i));}
		}
	}

}

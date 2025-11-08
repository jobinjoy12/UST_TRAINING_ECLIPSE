
public class ArithmeticExpression {
	public static void main(String[] args) {
	double depo = 100.0;
	float roi = 20;
	int thres = 170;
	int count = 0;
	while(depo<thres){
		depo = ((roi/100)*depo + depo) ;
		++count;
		System.out.println(count);
	}System.out.println(count);
}
}
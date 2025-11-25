public class Calculator {
	public int safeDivide(int numerator, int denominator) {
		try {
            return numerator/denominator;
        } catch (ArithmeticException e) {return -1;}
        }
	}


public class OperatorPlayground {
	public static void main(String[] args) {
		int num1 = 20; int num2 = 7;
		System.out.println("num1 + num2 = "+(num1+num2));
		System.out.println("num1 - num2 = "+(num1 - num2));
		System.out.println("num1 * num2 = "+(num1 * num2));
		System.out.println("num1 / num2 = "+(num1 / num2));
		System.out.println("num1 % num2 = "+(num1 % num2));
		
		//Arithmetic Operator
		int x = 15;
		x += 5;
		System.out.println(x);
		x -= 5;
		System.out.println(x);
		x *= 5;
		System.out.println(x);
		x /= 5;
		System.out.println(x);
		x %= 5;
		System.out.println(x);
		
		//Relational Operator
		int val1 = 10;
		int val2 = 20;
		System.out.println(val1 == val2);
		System.out.println(val1 != val2);
		System.out.println(val1 > val2);
		System.out.println(val1 < val2);
		System.out.println(val1 >= val2);
		System.out.println(val1 <= val2);
		
		//Logical operator
		boolean condition1 = true;
		boolean condition2 = false;
		System.out.println(condition1 && condition2);
		System.out.println(condition1 || condition2);
		System.out.println(!condition1);
		
		//unary operator
		int counter = 5;
		System.out.println("before"+counter);
		++counter;
		System.out.println("after ++ prefix"+counter);
		System.out.println("before"+counter);
		counter++;
		System.out.println("after ++ postfix "+counter);
		System.out.println("before"+counter);
		--counter;
		System.out.print("after -- prefix"+counter);
		System.out.println("before"+counter);
		counter--;
		System.out.println("after -- postfix counter"+counter);
		int a = +counter;
		int b = -counter;
		System.out.println(a);
		System.out.println(b);
		
		//ternary operator
		int temperature = 25;
		String str = (temperature >= 24) ? "Hot" : "Cold";
		System.out.println(str);}}


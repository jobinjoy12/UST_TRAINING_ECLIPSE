
abstract class PaymentProcessor {
	abstract boolean processPayment(double amount) ;
	public void displayProcessorType(){
		System.out.println("This is a generic payment processor.");
	}
}

class CreditCardPaymentProcessor extends PaymentProcessor {
	
	@Override
	public boolean processPayment(double amount){
		System.out.println("Processing "+amount+" via Credit Card.");
		return true;
	}
	
	@Override
	public void displayProcessorType() {
		System.out.println("This is a Credit Card payment processor.");
	}
	
	
}

class PayPalPaymentProcessor extends PaymentProcessor {
	@Override
	public boolean processPayment(double amount) {
		System.out.println("Processing "+amount+" via PayPal.");
		return true;
	}
	
	@Override
	public void displayProcessorType(){
		System.out.println("This is a PayPal payment processor.");
	}
	
}

public class Main{
	public static void main(String[] args) {
	CreditCardPaymentProcessor c1 = new CreditCardPaymentProcessor();
	PayPalPaymentProcessor p1 = new PayPalPaymentProcessor();
	c1.displayProcessorType();
	p1.displayProcessorType();
	c1.processPayment(100.50);
	p1.processPayment(25.00);
}}
package com.paymentrequest.app;

import com.paymentrequest.app.PaymentResponse.PaymentStatus;

public interface PaymentProcessor {
	PaymentResponse processPayment(PaymentRequest request);
	
}

class CreditCardProcessor implements PaymentProcessor
{
	@Override
	public PaymentResponse processPayment(PaymentRequest request)
	{
		String cardNumber  = request.getPaymentMethodDetails().get("credit card number");
		double amount = request.getAmount() ; 
		String transactionId = String.valueOf(Math.random());
		if(amount < 100.0 && cardNumber != null || cardNumber.endsWith("0")) {
			return new PaymentResponse(transactionId ,PaymentStatus.SUCCESS,"Approved Creditcard");
		}else {
			return new PaymentResponse(transactionId ,PaymentStatus.FAILED,"Failed Creditcard");

		}
		
	}
}

class PayPalProcessor implements  PaymentProcessor
{
	@Override
	public PaymentResponse processPayment(PaymentRequest request) 
	{
		String paypalNumber  = request.getPaymentMethodDetails().get(" paypal number");
		double amount = request.getAmount() ; 
		String transactionId = String.valueOf(Math.random());

		if(amount < 100.0 && paypalNumber != null || paypalNumber.endsWith("0")) {
			return new PaymentResponse(transactionId ,PaymentStatus.SUCCESS,"Approved Paypal");
		}else {
			return new PaymentResponse(transactionId ,PaymentStatus.FAILED,"Denied Paypal");
		}

	}
}
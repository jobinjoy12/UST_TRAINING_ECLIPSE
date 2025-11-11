import java.util.HashMap;
package com.paymentrequest.app;

import java.util.Map;

public class PaymentRequest {
	private double amount;
	private String currency;

	private PaymentMethodType paymentMethodType;
	
	private Map<String,String> paymentMethodDetails;
	
	public PaymentRequest(double amount , String currency , PaymentMethodType paymentMethodType , Map<String,String> paymentMethodDetails)
	{
	this.amount = amount ;
	this.currency = currency;
	this.paymentMethodType = paymentMethodType;
	this.paymentMethodDetails = paymentMethodDetails;
    }
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public PaymentMethodType getPaymentMethodType() {
		return paymentMethodType;
	}

	public void setPaymentMethodType(PaymentMethodType paymentMethodType) {
		this.paymentMethodType = paymentMethodType;
	}

	public Map<String, String> getPaymentMethodDetails() {
	return paymentMethodDetails;
	}

	public void setPaymentMethodDetails(Map<String, String> paymentMethodDetails) {
	this.paymentMethodDetails = paymentMethodDetails;
	}
	}

public enum PaymentMethodType{
		CREDIT_CARD , PAYPAL
}

package com.paymentrequest.app;

public class PaymentResponse{
	private String transactionId;
	private PaymentStatus status;
	private String message;
	
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PaymentResponse(String transactionId , PaymentStatus status, String message)
	{
		this.transactionId = transactionId;
		this.status = status ;
		this.message = message ;
	}
	
}

public enum PaymentStatus {
		SUCCESS , FAILED , PENDING
	}

public interface PaymentProcessor {
    PaymentResponse processPayment(PaymentRequest request);
}

import java.util.UUID;

public class CreditCardProcessor implements PaymentProcessor {
    @Override
    public PaymentResponse processPayment(PaymentRequest request) {
        String cardNumber = request.getPaymentMethodDetails().get("cardNumber");
        String transactionId = UUID.randomUUID().toString();

        if (request.getAmount() < 100 && cardNumber != null && cardNumber.endsWith("0")) {
            return new PaymentResponse(transactionId, PaymentStatus.SUCCESS, "Credit Card Payment Approved");
        } else {
            return new PaymentResponse(transactionId, PaymentStatus.FAILED, "Credit Card Payment Declined");
        }
    }
}

import java.util.UUID;

public class PayPalProcessor implements PaymentProcessor {
    @Override
    public PaymentResponse processPayment(PaymentRequest request) {
        String email = request.getPaymentMethodDetails().get("email");
        String transactionId = UUID.randomUUID().toString();

        if (request.getAmount() < 200 && email != null && email.contains("@")) {
            return new PaymentResponse(transactionId, PaymentStatus.SUCCESS, "PayPal Payment Approved");
        } else {
            return new PaymentResponse(transactionId, PaymentStatus.FAILED, "PayPal Payment Declined");
        }
    }
}

package com.paymentrequest.app;

import java.util.HashMap;
import java.util.Map;

import com.paymentrequest.app.PaymentMethodType;
import com.paymentrequest.app.PaymentStatus;

public class PaymentGateway {
	private Map<PaymentMethodType,PaymentProcessor> processors = new HashMap<>();
	
	public PaymentGateway() {
		processors.put(PaymentMethodType.CREDIT_CARD, new CreditCardProcessor());
        processors.put(PaymentMethodType.PAYPAL, new PayPalProcessor());
	}
	public PaymentResponse process(PaymentRequest request)
	{	
		PaymentProcessor processor = processors.get(request.getPaymentMethodType());
        if (processor != null) {
            return processor.processPayment(request);
        }
        return new PaymentResponse("N/A", PaymentStatus.FAILED, "Unsupported Payment Method");
		
	}
}


import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CreditCardProcessor ccProcessor = new CreditCardProcessor();
        PayPalProcessor paypalProcessor = new PayPalProcessor();
        PaymentGateway gateway = new PaymentGateway();

        // Valid Credit Card
        Map<String, String> ccDetails = new HashMap<>();
        ccDetails.put("cardNumber", "1234567890");
        ccDetails.put("expiryDate", "12/25");
        ccDetails.put("cvv", "123");
        PaymentRequest ccRequest = new PaymentRequest(50.0, "USD", PaymentMethodType.CREDIT_CARD, ccDetails);
        printResponse(gateway.process(ccRequest));

        // Valid PayPal
        Map<String, String> paypalDetails = new HashMap<>();
        paypalDetails.put("email", "user@example.com");
        paypalDetails.put("password", "securePass");
        PaymentRequest paypalRequest = new PaymentRequest(150.0, "EUR", PaymentMethodType.PAYPAL, paypalDetails);
        printResponse(gateway.process(paypalRequest));

        // Failed Credit Card (amount too high)
        PaymentRequest failedCCRequest = new PaymentRequest(300.0, "USD", PaymentMethodType.CREDIT_CARD, ccDetails);
        printResponse(gateway.process(failedCCRequest));

        // Invalid PayPal (missing email)
        Map<String, String> invalidPaypalDetails = new HashMap<>();
        invalidPaypalDetails.put("password", "noEmailPass");
        PaymentRequest invalidPaypalRequest = new PaymentRequest(80.0, "USD", PaymentMethodType.PAYPAL, invalidPaypalDetails);
        printResponse(gateway.process(invalidPaypalRequest));

        // Unsupported Method
        PaymentRequest unsupportedRequest = new PaymentRequest(40.0, "USD", null, ccDetails);
        printResponse(gateway.process(unsupportedRequest));

        // --- Additional Robust Error Handling Tests ---

        // Credit Card with expired date
        Map<String, String> expiredCCDetails = new HashMap<>();
        expiredCCDetails.put("cardNumber", "9876543210");
        expiredCCDetails.put("expiryDate", "01/20"); // Past date
        expiredCCDetails.put("cvv", "456");
        PaymentRequest expiredCCRequest = new PaymentRequest(60.0, "USD", PaymentMethodType.CREDIT_CARD, expiredCCDetails);
        printResponse(gateway.process(expiredCCRequest));

        Map<String, String> invalidCvvDetails = new HashMap<>();
        invalidCvvDetails.put("cardNumber", "5555555550");
        invalidCvvDetails.put("expiryDate", "11/30");
        invalidCvvDetails.put("cvv", "12AB"); // Invalid format
        PaymentRequest invalidCvvRequest = new PaymentRequest(70.0, "USD", PaymentMethodType.CREDIT_CARD, invalidCvvDetails);
        printResponse(gateway.process(invalidCvvRequest));
    }

    private static void printResponse(PaymentResponse response) {
        System.out.println("TransactionId: " + response.getTransactionId());
        System.out.println("Status: " + response.getStatus());
        System.out.println("Message: " + response.getMessage());
    }
}
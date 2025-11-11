package com.paymentrequest.app;

import java.util.HashMap;
import java.util.Map;

import com.paymentrequest.app.PaymentRequest.PaymentMethodType;
import com.paymentrequest.app.PaymentResponse.PaymentStatus;

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

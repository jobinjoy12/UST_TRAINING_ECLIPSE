package com.paymentrequest.app;

import java.util.Map;

public class PaymentRequest {
	private double amount;
	private String currency;

	private PaymentMethodType paymentMethodType;
	
	Map<String,String> paymentMethodDetails;
	
	public PaymentRequest(double amount , String currency , PaymentMethodType paymentMethodType , Map<String,String> paymentMethodDetails)
	{
	this.amount = amount ;
	this.currency = currency;
	this.paymentMethodType = paymentMethodType;
	this.paymentMethodDetails = paymentMethodDetails;
	}

	public enum PaymentMethodType{
		CREDIT_CARD , PAYPAL
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
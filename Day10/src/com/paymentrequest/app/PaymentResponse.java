package com.paymentrequest.app;

public class PaymentResponse{
	private String transactionId;
	private PaymentStatus Status;
	private String message;
	
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public PaymentStatus getStatus() {
		return Status;
	}

	public void setStatus(PaymentStatus status) {
		Status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PaymentResponse(String transactionId , PaymentStatus Status, String message)
	{
		this.transactionId = transactionId;
		this.Status = Status ;
		this.message = message ;
	}
	
	public enum PaymentStatus {
		SUCCESS , FAILED , PENDING
	}
}


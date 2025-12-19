package com.example.employeemanager.exception;

public class ErrorResponse {
	private int status;
	private String message;

	public ErrorResponse(int status, String message) {
		this.status = status;
		this.message = message;
	}

	// Getters for status and message
	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	// Setters (optional, typically not needed for immutable error responses)
	public void setStatus(int status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
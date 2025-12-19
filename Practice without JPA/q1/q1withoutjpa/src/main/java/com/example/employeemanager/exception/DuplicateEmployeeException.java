package com.example.employeemanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateEmployeeException extends RuntimeException {
	public DuplicateEmployeeException(String message) {
		super(message);
	}
}
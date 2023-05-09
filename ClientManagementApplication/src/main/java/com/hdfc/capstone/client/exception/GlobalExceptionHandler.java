package com.hdfc.capstone.client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<String> handleNumberFormatException(NumberFormatException exc){
		return new ResponseEntity<String>("EmployeeId can only be in long format.", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> handleEmployeeNotFoundexception(EmployeeNotFoundException exc){
		return new ResponseEntity<String>("No Employee found with the given Id.",HttpStatus.NOT_FOUND);
	}
}

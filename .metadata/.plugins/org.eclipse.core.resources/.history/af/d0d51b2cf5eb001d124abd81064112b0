package com.hdfc.capstone.employeemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InvalidEmployeeIdException.class)
	public ResponseEntity<String> handleInvalidEmployeeIdException(InvalidEmployeeIdException exc){
		return new ResponseEntity<String>("EmployeeId is not in the long format.",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<String> handleNumberFormatException(NumberFormatException exc){
		return new ResponseEntity<String>("Provide the employeeId in long format only", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> handleEmployeeNotFoundexception(EmployeeNotFoundException exc){
		return new ResponseEntity<String>("No Employee found with the given Id.",HttpStatus.NOT_FOUND);
	}
}

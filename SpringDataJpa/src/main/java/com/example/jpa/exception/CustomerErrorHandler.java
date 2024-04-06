package com.example.jpa.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@RestControllerAdvice
@ControllerAdvice
public class CustomerErrorHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorType> customerNotFoundException(CustomerNotFoundException ex) {

		 ErrorType errorType=new ErrorType(new Date(System.currentTimeMillis()).toString(), "404- NOT FOUND", ex.getMessage());
		//return new ResponseEntity<ErrorType>(
			//	new ErrorType(new Date(System.currentTimeMillis()).toString(), "404- NOT FOUND", ex.getMessage()),

		return new ResponseEntity<ErrorType>(errorType, HttpStatus.NOT_FOUND);
	}
}

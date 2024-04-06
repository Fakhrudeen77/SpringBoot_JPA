package com.example.jpa.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.jpa.Error.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse>handleBookNotFoundException(BookNotFoundException ex,WebRequest request) {
        //return new ErrorResponse("Book not found: " + ex.getMessage());
        
        System.out.println("BookNotFoundException Occured ");
		 ErrorResponse message = new ErrorResponse(
	        HttpStatus.FOUND.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorResponse>(message, HttpStatus.FOUND);
    }
	
	
	 @ExceptionHandler(DepartmentIdNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  public ResponseEntity<ErrorResponse> DepartmentIdNotFoundException(DepartmentIdNotFoundException ex, WebRequest request) {
		 System.out.println("DepartmentIdNotFoundException Occured ");
		 ErrorResponse message = new ErrorResponse(
	        HttpStatus.FOUND.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorResponse>(message, HttpStatus.NOT_FOUND);
	  }
	 
}

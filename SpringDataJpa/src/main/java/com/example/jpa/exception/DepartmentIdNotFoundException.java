package com.example.jpa.exception;

public class DepartmentIdNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DepartmentIdNotFoundException() {
		
	}

	public DepartmentIdNotFoundException(String message) {
		super(message);
		
	}
 
}

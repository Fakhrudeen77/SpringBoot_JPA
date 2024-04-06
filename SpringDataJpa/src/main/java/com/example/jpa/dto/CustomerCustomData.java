package com.example.jpa.dto;

import java.io.Serializable;

public class CustomerCustomData implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public CustomerCustomData() {
		
	}

	public CustomerCustomData(Long customerId,String customerName) {
		this.customerId=customerId;
		this.customerName=customerName;
	}
	private Long customerId;
	private String customerName;
	
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
}

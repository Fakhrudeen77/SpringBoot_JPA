package com.example.jpa.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.jpa.dto.CustomerCustomData;
import com.example.jpa.entity.Customer;
import com.example.jpa.exception.CustomerNotFoundException;

@Component
public interface CustomerService {
	public Customer saveCustomer(Customer customer);
	public List<Customer> getCustomerList();
	public Customer getCustomerById(Long customerId) throws CustomerNotFoundException;
	public void delete(Long customerId) throws CustomerNotFoundException;
	public List<CustomerCustomData> getCustomerIdAndName();
	public Customer getCustomerIdAndCustomerName();
	public List<Customer> getCustomerWithOrdered();
	public List<Customer> getCustomerWithRejected();
	
	

}

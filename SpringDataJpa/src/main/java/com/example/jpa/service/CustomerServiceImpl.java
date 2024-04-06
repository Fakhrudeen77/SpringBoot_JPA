package com.example.jpa.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa.dto.CustomerCustomData;
import com.example.jpa.entity.Customer;
import com.example.jpa.exception.CustomerNotFoundException;
import com.example.jpa.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	@Transactional
	public Customer saveCustomer(Customer customer) {
		
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getCustomerList() {
		
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(Long customerId) throws CustomerNotFoundException {
			
		Customer customer=null;
		Optional<Customer> option=null;
		boolean isFlag=false;
		try {
			 isFlag = existsById(customerId);
		}
		catch(CustomerNotFoundException ex) {
			throw ex;
		}

		if(isFlag) {
			 option=customerRepository.findById(customerId);
			 
			 if (option.isPresent()) {
					
					customer=option.get();
				}
		}
		

		return customer;		
		
	}
	
	public boolean existsById(Long customerId) throws CustomerNotFoundException{
		
		boolean isFlag=customerRepository.existsById(customerId);
		System.out.println("ExistById Flag"+" "+isFlag);
		if(!isFlag) {
			System.out.println("Inside coming");
			throw new CustomerNotFoundException(
					new StringBuffer()
					.append("Customer")
					.append(customerId)
					.append("' not exist")
					.toString());
		}
		return true;
	}

	@Override
	@Transactional
	public void  delete(Long customerId) throws CustomerNotFoundException {
		  
		 try {
			 boolean isFlag= this.existsById(customerId);
			 if(isFlag) {
				 customerRepository.deleteById(customerId);
			 }
			
		 }
		 catch(CustomerNotFoundException ex) {
			throw ex;
		 }	 

}

	@Override
	public List<CustomerCustomData> getCustomerIdAndName() {
		// TODO Auto-generated method stub
		//List<CustomerCustomData> list=customerRepository.getCustomerIdAndName();
		//System.out.println("CustomerDto List"+" "+list.size());
		return customerRepository.getCustomerIdAndName();
	}

	@Override
	public Customer getCustomerIdAndCustomerName() {
		Customer customer=new Customer();
		customer.setCustomerId(241l);
		customer.setCustomerName("Fakhrudeen Ali Ahamed");		
		Customer fetchedCustomer=customerRepository.getCustomerIdAndCustomerName(customer.getCustomerId(), customer.getCustomerName());
				
		return fetchedCustomer;
		
		
	}

	@Override
	public List<Customer> getCustomerWithOrdered() {
		// TODO Auto-generated method stub
		return customerRepository.getCustomerWithOrdered();
	}

	@Override
	public List<Customer> getCustomerWithRejected() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
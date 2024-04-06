package com.example.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.dto.CustomerCustomData;
import com.example.jpa.dto.CustomerDto;
import com.example.jpa.entity.Customer;
import com.example.jpa.exception.CustomerNotFoundException;
import com.example.jpa.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/saveCustomer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
				
		try {
			//customer.setOrderList(null);
			return new ResponseEntity<Customer>(customerService.saveCustomer(customer),HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
				
		try {
			return new ResponseEntity<Customer>(customerService.saveCustomer(customer),HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	
	@GetMapping("/getCustomerList")
	public ResponseEntity<List<Customer>> getCustomerList(){
				
		try {
			return new ResponseEntity<List<Customer>>(customerService.getCustomerList(),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	

	@GetMapping("/getCustomerById/{customerId}")
	public ResponseEntity<?> getCustomerById(@PathVariable  Long customerId) throws CustomerNotFoundException{
		
		ResponseEntity<?> resp= null;
		try {
			
			resp=  new ResponseEntity<Customer>(customerService.getCustomerById(customerId),HttpStatus.OK);
		} catch (CustomerNotFoundException e) {
		
			resp=new ResponseEntity<String>(
					new StringBuffer()
					.append("Customer")
					.append(" ")
					.append(customerId)
					.append("not exist")
					.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return resp;
		
		
				
		/*try {
			return new ResponseEntity<Customer>(customerService.getCustomerByCustId(customerId),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}*/
		
	}
		
	
	@DeleteMapping("/deleteCustomerByCustId/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Long customerId) throws CustomerNotFoundException {
		ResponseEntity<String> resp= null;
		try {
			customerService.delete(customerId);
			//return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			resp= new ResponseEntity<String> (
					"Customer '"+customerId+"' deleted",HttpStatus.OK);
		} catch (CustomerNotFoundException e) {
		
			resp=new ResponseEntity<String>(
					new StringBuffer()
					.append("Customer")
					.append(" ")
					.append(customerId)
					.append("not exist")
					.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return resp;
		
	}
	
	@GetMapping("/getCustomerIdAndName")
	public ResponseEntity<List<CustomerCustomData>> getCustomerIdAndName(){
				
		try {
			//return new ResponseEntity<List<CustomerDto>>(customerService.getCustomerIdAndName(),HttpStatus.OK);
			return new ResponseEntity<List<CustomerCustomData>>(customerService.getCustomerIdAndName(),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	//getCustomerIdAndCustomerName
	
	/*@GetMapping("/getCustomerIdAndCustomerName")
	public ResponseEntity<Customer> getCustomerIdAndCustomerName(){
				
		try {
			return new ResponseEntity<Customer>(customerService.getCustomerIdAndCustomerName(),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}*/
	
	
	
	@GetMapping("/getCustomerWithOrdered")
	public ResponseEntity<List<Customer>> getCustomerWithOrdered(){
				
		try {
			return new ResponseEntity<List<Customer>>(customerService.getCustomerWithOrdered(),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	

}

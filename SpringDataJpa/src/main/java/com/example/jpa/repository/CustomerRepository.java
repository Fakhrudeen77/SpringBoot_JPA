package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.jpa.dto.CustomerCustomData;
import com.example.jpa.dto.CustomerDto;
import com.example.jpa.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	
	/*@Query(value = "SELECT new com.example.jpa.dto.CustomerDto(c.customerId, c.customerName)"
			+ " FROM Customer c")
	List<CustomerDto> getCustomerIdAndName();*/
	
	
	
	@Query(value = "SELECT c FROM Customer c WHERE c.customerId= :customerId AND c.customerName= :customerName")
	//@Query(value = "SELECT c FROM Customer c WHERE c.customerId=241")
	Customer getCustomerIdAndCustomerName(
			@Param("customerId") Long customerId,
			@Param("customerName") String customerName);	
	
	

	@Query(value = "SELECT c FROM Customer c INNER JOIN Order co ON c.customerId=co.customer.customerId WHERE co.orderStatus='Rejected'")
	
	//@Query(value = "SELECT c FROM Customer c INNER JOIN CustomerOrder co "	+ " ON c.id=co.customerId WHERE co.orderStatus='Rejected'")
	List<Customer> getCustomerWithOrdered();
	
	
	@Query(value = "SELECT new com.example.jpa.dto.CustomerCustomData(c.customerId, c.customerName)"
			+ " FROM Customer c")
	List<CustomerCustomData> getCustomerIdAndName();
	
	
}

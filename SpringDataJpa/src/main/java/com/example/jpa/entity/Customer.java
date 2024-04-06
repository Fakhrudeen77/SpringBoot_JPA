package com.example.jpa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Customer")
public class Customer implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Long customerId;
	private String customerName;
	private Long age;
	private Date dateOfBirth;
	private String location;
	private List<Order> orderList=new ArrayList<Order>();
	
	public Customer() {
		
	}
	
	public Customer(Long customerId,String customerName) {
		this.customerId=customerId;
		this.customerName=customerName;
	}
	
	
	public Customer(Long customerId, String customerName, Long age, Date dateOfBirth, String location,
			List<Order> orderList) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.age = age;
		this.dateOfBirth = dateOfBirth;
		this.location = location;
		this.orderList = orderList;
	}

		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Customer_Id")
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	@Column(name = "Customer_Name")
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Column(name = "Age")
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	
	@Column(name = "Dob")
	@Temporal(value=TemporalType.DATE)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@Column(name = "Location")
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy="customer", cascade = CascadeType.ALL)
	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		
		this.orderList = orderList;
	}
	
	
	

	
	

	
	
	
}

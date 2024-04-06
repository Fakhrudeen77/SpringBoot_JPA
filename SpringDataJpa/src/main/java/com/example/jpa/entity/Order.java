package com.example.jpa.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Customer_Order")
public class Order implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private Long customer_orderId;
	private String orderDescribtion;
	private String orderStatus;
	private Customer customer;
		
	public Order() {
	
	}
		

	public Order(Long customer_orderId, String orderDescribtion, String orderStatus, Customer customer) {
		super();
		this.customer_orderId = customer_orderId;
		this.orderDescribtion = orderDescribtion;
		this.orderStatus = orderStatus;
		this.customer = customer;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Order_Id")
	public Long getCustomer_orderId() {
		return customer_orderId;
	}

	public void setCustomer_orderId(Long customer_orderId) {
		this.customer_orderId = customer_orderId;
	}

	
	@Column(name = "Order_Desc")
	public String getOrderDescribtion() {
		return orderDescribtion;
	}
	public void setOrderDescribtion(String orderDescribtion) {
		this.orderDescribtion = orderDescribtion;
	}
	@Column(name = "Order_Status")
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="Customer_Id")
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}

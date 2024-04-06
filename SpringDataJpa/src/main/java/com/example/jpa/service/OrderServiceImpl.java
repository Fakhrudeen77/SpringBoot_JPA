package com.example.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa.entity.Order;
import com.example.jpa.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	@Override
	public List<Order> getOrderList() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}
	@Override
	public Order saveOrder(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.saveAndFlush(order);
	}

	
	

}

package com.example.jpa.service;

import java.util.List;

import com.example.jpa.entity.Order;

public interface OrderService {
	public Order saveOrder(Order order);
	public List<Order> getOrderList();
}

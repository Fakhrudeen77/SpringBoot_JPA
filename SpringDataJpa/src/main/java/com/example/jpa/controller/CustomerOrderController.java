package com.example.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.entity.Order;
import com.example.jpa.service.OrderService;
@RestController
@RequestMapping("/order")
public class CustomerOrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("/saveOrder")
	public ResponseEntity<Order> saveOrder(@RequestBody Order order){
				
		try {
			return new ResponseEntity<Order>(orderService.saveOrder(order),HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/getOrderList")
	public ResponseEntity<List<Order>> getOrderList(){
				
		try {
			return new ResponseEntity<List<Order>>(orderService.getOrderList(),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	

}

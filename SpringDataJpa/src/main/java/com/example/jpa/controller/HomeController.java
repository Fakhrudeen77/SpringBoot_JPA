package com.example.jpa.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	
	@GetMapping("/home1")
	public String home() {
		return "Welcome to Home";
	}
	
	@GetMapping("/protect")
	public String protect() {
		return "Welcome to Protected";
	}
	
	
}

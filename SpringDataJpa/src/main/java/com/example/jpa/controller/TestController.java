package com.example.jpa.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	
	@Value("${app.name}")
	private String appName;
	
	
	@Value("${product.title}")
    private String title;

    @Value("${product.version}")
    private Double version;
	
	
   @GetMapping("/home")
   public ResponseEntity<String> getHome(){
	   
	   System.out.println("Welcome to Home");
	   return new ResponseEntity<String>("Welcome to Home Page",HttpStatus.OK);
	   
   }
   
   @GetMapping("/balance")
   public ResponseEntity<String> getBalance(){
	   
	   return new ResponseEntity<String>("My Balance is Rs 47000",HttpStatus.OK);
	   
   }
   
   @GetMapping("/statement")
   public ResponseEntity<String> getStatement(){
	   
	   return new ResponseEntity<String>("My Statement send in Email",HttpStatus.OK);
	   
   }
   
   @GetMapping("/loan")
   public ResponseEntity<String> getMyLoan(){
	   
	   return new ResponseEntity<String>("My Loan",HttpStatus.OK);
	   
   }
	
   @GetMapping("/contact")
   public ResponseEntity<String> getContact(){
	   
	   return new ResponseEntity<String>("My Contact Details -8015409728",HttpStatus.OK);
	   
   }
	
 
   @PreAuthorize("hasRole('ROLE_ADMIN')")
   @GetMapping("/deleteuser")
   public ResponseEntity<String> deleteUser() {
	   return new ResponseEntity<String>("User has been Deleted ",HttpStatus.OK);
	   
   }
 
}

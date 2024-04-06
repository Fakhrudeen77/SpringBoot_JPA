package com.example.jpa.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/profile")
public class ProfileController {
	
	@Value("${profile.desc}")
	private String profileDesc;
	
	@GetMapping("/profile")
	public ResponseEntity<String> getProfile(){
		return new ResponseEntity<String>(profileDesc,HttpStatus.OK);
		
	}

	
}

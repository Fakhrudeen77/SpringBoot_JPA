package com.example.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.dto.EmployeeDto;
import com.example.jpa.entity.Employee;
import com.example.jpa.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins="http://localhost:4200")  

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	  
		
	@PostMapping("/saveEmployee")
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
		
	    
		return new ResponseEntity<EmployeeDto>(employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);
					    
	}
	
	

	@GetMapping("/getEmployeeList")
	public ResponseEntity<List<Employee>> getEmployeeList(){
				
		try {
			return new ResponseEntity<List<Employee>>(employeeService.getEmployeeList(),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	

	

	
	
	

}

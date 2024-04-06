package com.example.jpa.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.jpa.entity.Employee;
import com.example.jpa.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins="http://localhost:4200")  

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	//let requestParam="?name="+employee.name+"&gender="+employee.gender+"&email="+employee.email+"&phoneNumber="+employee.phoneNumber+"&contactPreference="+employee.contactPreference+"&dateOfBirth="+employee.dateOfBirth+"&department="+employee.department+"&isActive="+employee.isActive;   
		
	@PostMapping("/saveEmployee")
	public ResponseEntity<Long> saveEmployee(@RequestParam String name, @RequestParam String gender,@RequestParam String email,@RequestParam String phoneNumber,@RequestParam String contactPreference,@RequestParam String dateOfBirth,@RequestParam String department,@RequestParam boolean isActive, @RequestParam("imageFile") MultipartFile file)  throws IOException {
		
	    System.out.println("SaveEmployee called*************8"+name);
	    Employee employee=null;
	    try {
	    	employee=new Employee();
			employee.setName(name);
			employee.setGender(gender);
			employee.setEmail(email);
			employee.setPhoneNumber(phoneNumber);
			employee.setContactPreference(contactPreference);
		    System.out.println("Date is"+" "+dateOfBirth);
		   
			employee.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth));
			
		    System.out.println("Date of Birth"+" "+employee.getDateOfBirth());
			employee.setDepartment(department);
			System.out.println("Department"+" "+employee.getDepartment());
			employee.setActive(true);
			
			
			employee.setPhotoPath(file.getBytes());
		
	    }
	    catch(ParseException e) {
	    	e.getMessage();
	    }
		
	    
		return new ResponseEntity<Long>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
		
		//return null;
		
		
	    
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

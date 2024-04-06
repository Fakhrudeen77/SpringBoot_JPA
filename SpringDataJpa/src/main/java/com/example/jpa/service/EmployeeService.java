package com.example.jpa.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.jpa.entity.Employee;
import com.example.jpa.exception.CustomerNotFoundException;

@Component
public interface EmployeeService {
	
	public Long saveEmployee(Employee employee);
	public Employee getEmployeeById(Long employeeId);
	public List<Employee> getEmployeeList();
	public void delete(Long employeeId) throws CustomerNotFoundException;
		
}

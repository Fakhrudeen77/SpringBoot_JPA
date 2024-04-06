package com.example.jpa.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.jpa.dto.EmployeeDto;
import com.example.jpa.entity.Employee;
import com.example.jpa.exception.CustomerNotFoundException;

@Component
public interface EmployeeService {
	
	public EmployeeDto saveEmployee(EmployeeDto employeeDto);
	public Employee getEmployeeById(Long employeeId);
	public List<Employee> getEmployeeList();
	
		
}

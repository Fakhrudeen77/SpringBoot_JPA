package com.example.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa.entity.Employee;
import com.example.jpa.exception.CustomerNotFoundException;
import com.example.jpa.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Long saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee empl= employeeRepository.saveAndFlush(employee);
		return empl.getEmployeeId();
	}

	@Override
	public List<Employee> getEmployeeList() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long employeeId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		
	}

	 public int updateProfileImage(String profileImage, Long employeeId) {  
		   
		 return employeeRepository.updateProfileImage(profileImage, employeeId);
	 }
	

	
	

}

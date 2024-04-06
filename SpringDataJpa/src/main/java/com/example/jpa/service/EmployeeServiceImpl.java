package com.example.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.dto.EmployeeDto;
import com.example.jpa.entity.Employee;
import com.example.jpa.mapper.OrikaBeanMapper;
import com.example.jpa.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private OrikaBeanMapper mapper;
	
	
	@Override
	@Transactional
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
	
		Employee employee= mapper.map(employeeDto, Employee.class);
		employee= employeeRepository.saveAndFlush(employee);
		
		
		EmployeeDto responseDto  = mapper.map(employee, EmployeeDto.class);
		return responseDto;		
		
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


	
	

}

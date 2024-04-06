package com.example.jpa.dto;

import java.io.Serializable;

public class EmployeeDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long employeeId;
	private String name;
	private DepartmentDto department;
		
	public EmployeeDto() {
		
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DepartmentDto getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDto department) {
		this.department = department;
	}

	
	
	
	

}

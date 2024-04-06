package com.example.jpa.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.jpa.dto.DepartmentDto;

@Component
public interface DepartmentService {
	
	public DepartmentDto saveDepartment(DepartmentDto departmentDto);
	public List<DepartmentDto> getDepartmentList();
	public int deleteByDeptId(Long deptId );
}

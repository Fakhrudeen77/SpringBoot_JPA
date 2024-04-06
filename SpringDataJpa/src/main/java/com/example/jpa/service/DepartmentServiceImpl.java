package com.example.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.dto.DepartmentDto;
import com.example.jpa.entity.Department;
import com.example.jpa.mapper.OrikaBeanMapper;
import com.example.jpa.repository.DepartmentRepository;



@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private OrikaBeanMapper mapper;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	

	@Override
	@Transactional
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		
		Department department= mapper.map(departmentDto, Department.class);
		department= departmentRepository.saveAndFlush(department);
		
		
		DepartmentDto deptmentDto  = mapper.map(department, DepartmentDto.class);
		return deptmentDto;		
		
		
	}

	@Override
	public List<DepartmentDto> getDepartmentList() {
		List<Department> departmentList= departmentRepository.findAll();
		List<DepartmentDto> departmentDtoList=mapper.mapAsList(departmentList, DepartmentDto.class);
		return departmentDtoList;
	}

	@Override
	public int deleteByDeptId(Long deptId) {
		
		 int result=0;		
		 try {
			 if(this.checkDepartmentIdExistOrNot(deptId)) 
				 result=departmentRepository.deleteByDeptId(deptId);
				 		
			
			/* else 
				 throw new BloodGroupIdNotFoundException("BloodGroup Id"+" "+bloodGroupId+" "+"Not Found");
			 }*/
				
		 }
		
		catch(Exception e) {
			System.out.println("Exception Occured");
		}
		 return result;		
		 
		
		
	}
	
	
	public boolean checkDepartmentIdExistOrNot(Long deptId  ) {
		boolean isFlag=false;
		Optional<Department> option = departmentRepository.findById(deptId);

		if (option.isPresent()) {
			return isFlag=true;
		}

		return isFlag;
	}

}

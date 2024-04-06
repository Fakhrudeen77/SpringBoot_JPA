package com.example.jpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.dto.DepartmentDto;
import com.example.jpa.exception.DepartmentIdNotFoundException;
import com.example.jpa.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/saveDepartment")
	public ResponseEntity<DepartmentDto> saveCustomer(@RequestBody DepartmentDto departmentDto){
				
		try {
			
			return new ResponseEntity<DepartmentDto>(departmentService.saveDepartment(departmentDto),HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<DepartmentDto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@GetMapping("/getDepartmentList")
	public ResponseEntity<List<DepartmentDto>> getDepartmentList(){
				
		List<DepartmentDto> departmentList=new ArrayList<DepartmentDto>();
		departmentList=departmentService.getDepartmentList();
		System.out.println("Department List Size"+" "+departmentList.size());
		
		if(departmentList.isEmpty() || departmentList.size()==0 || departmentList==null) {
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<DepartmentDto>>(departmentList,HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/deleteByDeptId/{deptId}")
	public ResponseEntity<String> deleteByDeptId(@PathVariable Long deptId) throws  DepartmentIdNotFoundException  {
	    System.out.println("Hitting");
		ResponseEntity<String> resp= null;
		
		/*try 
		{
			int result=departmentService.deleteByDeptId(deptId);
			System.out.println("Result value"+" "+result);
			if(result==1)
			resp= new ResponseEntity<String> ("Department Id "+deptId+"' deleted",HttpStatus.OK);
			else {
				System.out.println("Department Id"+" "+deptId+" "+"Does Not Exist");
				throw new DepartmentIdNotFoundException("Department Id"+" "+deptId+" "+"Does Not Exist");		
			}
				
				
		} catch (Exception e) {
			resp= new ResponseEntity<String> ("Department Id "+deptId+"' Does Not Exist",HttpStatus.NOT_FOUND);
			System.out.println("Exception Occured **************");
		}	
		return resp;*/
		
		
		int result=departmentService.deleteByDeptId(deptId);
		System.out.println("Result value"+" "+result);
		if(result==1)
		resp= new ResponseEntity<String> ("Department Id "+deptId+"' deleted",HttpStatus.OK);
		else {
			System.out.println("Department Id"+" "+deptId+" "+"Does Not Exist");
			throw new DepartmentIdNotFoundException("Department Id"+" "+deptId+" "+"Does Not Exist");		
		}
			
		return resp;
		
		
	}	
	
	
	

}

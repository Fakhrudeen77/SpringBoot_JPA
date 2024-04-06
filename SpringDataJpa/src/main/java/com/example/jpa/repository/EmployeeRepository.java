package com.example.jpa.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.jpa.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>  {
	
	@Modifying
	@Transactional
	@Query(value="update Employee set photoPath = :photoPath where employeeId=:employeeId ")
	public int updateProfileImage(@Param("photoPath") String photoPath,@Param("employeeId") Long employeeId);
	
	
	
}

package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

	@Modifying
	@Transactional	
	@Query("delete from Department d  where d.deptId=:deptId")
	public int deleteByDeptId(@Param("deptId") Long deptId);
}

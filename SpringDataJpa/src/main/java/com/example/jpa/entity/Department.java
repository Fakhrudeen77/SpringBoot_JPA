package com.example.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Department")
public class Department implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private Long deptId;
	private String deptName;
	
	public Department() {
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Dept_Id")
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	@Column(name = "Dept_Name")
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}

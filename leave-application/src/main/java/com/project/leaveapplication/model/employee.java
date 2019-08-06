package com.project.leaveapplication.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@Entity
@Table(name="employee")
@JsonIgnoreProperties(value = {"leaveCount"}, allowGetters = true)
public class employee
{
	@Id
	private Long empId;
	
	private String empName;
	
	private int leaveCount=10;
	
	@ManyToOne()
    @JoinColumn(name = "deptId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private department dept;

	
	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long string) {
		this.empId = string;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getLeaveCount() {
		return leaveCount;
	}

	public void setLeaveCount(int leaveCount) {
		this.leaveCount = leaveCount;
	}

	public department getDept() {
		return dept;
	}

	public void setDept(department dept) {
		this.dept = dept;
	}

	public void show()
	{
		System.out.println("Employee Working!");
	}
}

package com.project.leaveapplication.Dto;

public class employeeDto 
{
	public Long empId;
	public String empName;
	public Long deptId;
	
	public employeeDto()
	{
		
	}
	public employeeDto(Long empId,String empName,Long deptId)
	{
		this.empId = empId;
		this.empName = empName;
		this.deptId = deptId;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return "employeeDto [empId=" + empId + ", empName=" + empName + ", deptId=" + deptId + "]";
	}
	
	
}

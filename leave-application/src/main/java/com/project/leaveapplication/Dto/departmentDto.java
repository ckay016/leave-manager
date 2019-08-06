package com.project.leaveapplication.Dto;

public class departmentDto 
{
	public Long deptId;
	public String deptName;
	
	public departmentDto()
	{
		
	}
	public departmentDto(Long deptId,String deptName)
	{
		this.deptId = deptId;
		this.deptName = deptName;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return "departmentDto [deptId=" + deptId + ", deptName=" + deptName + "]";
	}
	
	
}

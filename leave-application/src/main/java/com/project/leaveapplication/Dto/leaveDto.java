package com.project.leaveapplication.Dto;
import com.project.leaveapplication.model.Status;

public class leaveDto 
{
	public Long leaveId;
	public Long empId;
	public String startDate;
	public int Days;
	public Status status;
	public String reason;
	
	public leaveDto()
	{
		
	}

	public Long getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Long leaveId) {
		this.leaveId = leaveId;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public int getDays() {
		return Days;
	}

	public void setDays(int days) {
		Days = days;
	}



	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	/*
	 * @Override public String toString() { return "leaveDto [leaveId=" + leaveId +
	 * ", empId=" + empId + ", startDate=" + startDate + ", Days=" + Days +
	 * ", status=" + status + ", reason=" + reason + "]"; }
	 */

	public leaveDto(Long leaveId, Long empId, String startDate, int days, Status status, String reason) 
	{
		this.leaveId = leaveId;
		this.empId = empId;
		this.startDate = startDate;
		this.Days = days;
		this.status = status;
		this.reason = reason;
	}
	
	
	
}

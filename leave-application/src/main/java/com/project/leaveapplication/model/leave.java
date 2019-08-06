package com.project.leaveapplication.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
@Table(name="leavetable")
public class leave
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long leaveId;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "empId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private employee emp;
	
	private String startDate;
	
	private int Days;
	
	private Status status;
	
	private String reason;
	
	public Long getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Long leaveId) {
		this.leaveId = leaveId;
	}

	

	public employee getEmp() {
		return emp;
	}

	public void setEmp(employee emp) {
		this.emp = emp;
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

	public void show()
	{
		System.out.println("Leave Working!");
	}
}

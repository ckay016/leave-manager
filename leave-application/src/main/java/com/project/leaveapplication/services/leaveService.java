package com.project.leaveapplication.services;

import java.util.List;

import org.hibernate.service.Service;

import com.project.leaveapplication.Dto.leaveDto;
import com.project.leaveapplication.model.Status;
import com.project.leaveapplication.model.leave;
public interface leaveService extends Service 
{
	public leave addLeave(leaveDto leaDto);
	public List<leave> getAllLeave();
	public leave getLeaveById(Long leaveId);
	public leave updateLeave(leaveDto leaDto, Long leaveId, Status status);
}

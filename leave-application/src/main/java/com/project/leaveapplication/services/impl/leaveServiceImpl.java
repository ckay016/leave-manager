package com.project.leaveapplication.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.leaveapplication.Dto.leaveDto;
import com.project.leaveapplication.exceptions.ResourceNotFoundException;
import com.project.leaveapplication.model.Status;
import com.project.leaveapplication.model.employee;
import com.project.leaveapplication.model.leave;
import com.project.leaveapplication.repository.employeeRepository;
import com.project.leaveapplication.repository.leaveRepository;
import com.project.leaveapplication.services.leaveService;

@Service
public class leaveServiceImpl implements leaveService
{
	
		@Autowired
		leaveRepository leaveRepo;
		
		@Autowired
		employeeRepository empRepo;
		
		public leave addLeave(leaveDto leaDto)
		{
			leave lev = new leave();
			lev.setStartDate(leaDto.getStartDate());
			int days = leaDto.getDays();
			lev.setDays(days);
			lev.setReason(leaDto.getReason());
			lev.setStatus(leaDto.getStatus());
			//System.out.println(leaDto.getStatus());
			employee emp = empRepo.findById(leaDto.getEmpId()).get();
			lev.setEmp(emp);
			
			int leavecount = emp.getLeaveCount();
			if(leavecount<=0)
			{
				System.out.println("No more leaves for you!");
				leaveRepo.save(lev);
				empRepo.save(emp);
			}
			else
			{
				int finalcount = leavecount - days;
				System.out.println(finalcount);
				if(finalcount<0)
				{
					System.out.println("Take less leaves please!");
					leaveRepo.save(lev);
					empRepo.save(emp);
				}
				else
				{
					emp.setLeaveCount(finalcount);
					empRepo.save(emp);
					leaveRepo.save(lev);
				}
			 	
			}
			
			return lev;
		}

		@Override
		public List<leave> getAllLeave() 
		{
			return leaveRepo.findAll();
		}

		@Override
		public leave getLeaveById(Long leaveId) 
		{
			leave lev = leaveRepo.findById(leaveId).orElseThrow(() -> new ResourceNotFoundException("Leave", "id", leaveId));
		    return lev;
		}

		@Override
		public leave updateLeave(leaveDto leaDto, Long leaveId, Status status) 
		{
			leave lev = leaveRepo.findById(leaveId).orElseThrow(() -> new ResourceNotFoundException("Leave", "id", leaveId));
		    lev.setStatus(status);
		    leaveRepo.save(lev);
			System.out.println(status);
			return lev;
		}
}


package com.project.leaveapplication.controllers;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.leaveapplication.Dto.leaveDto;
import com.project.leaveapplication.exceptions.ResourceNotFoundException;
import com.project.leaveapplication.model.Status;
import com.project.leaveapplication.model.leave;
import com.project.leaveapplication.repository.leaveRepository;
import com.project.leaveapplication.services.leaveService;

@ComponentScan({"com.project.leaveapplication.services.leaveService"})
@RestController
@RequestMapping("/leave")
public class leaveController
{
	@Autowired
	leaveService levService;
	@Autowired
	leaveRepository leaveRepo;
	
	@PostMapping("/details")
	public leave addLeave(@Valid @RequestBody leaveDto leaDto)
	{
		return levService.addLeave(leaDto);
	}
	
	@GetMapping("/details")
	public List<leave> getAllLeave()
	{
		return levService.getAllLeave();
	}
	
	@GetMapping("/details/{id}")
	public leave getLeaveById(@Valid @PathVariable(value="id") Long leaveId)
	{
		return levService.getLeaveById(leaveId);
	}
	
	
	
	@PutMapping("/details/{id}/{status}")
	public leave updateLeave(@Valid @RequestBody leaveDto leaDto, @PathVariable(value="id")Long leaveId, @PathVariable(value="status")Status status)
	{
		return levService.updateLeave(leaDto, leaveId, status);
	}
}

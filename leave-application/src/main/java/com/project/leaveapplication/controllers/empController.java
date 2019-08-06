package com.project.leaveapplication.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.leaveapplication.Dto.departmentDto;
import com.project.leaveapplication.Dto.employeeDto;
import com.project.leaveapplication.model.department;
import com.project.leaveapplication.model.employee;
import com.project.leaveapplication.services.employeeService;

@RestController
@RequestMapping("/emp")
public class empController
{
	@Autowired
	employeeService empService;
	
	@PostMapping("/details")
	public employee addEmployee(@Valid @RequestBody employeeDto empDto)
	{
		return empService.addEmployee(empDto);
	}
	

	@GetMapping("/details")
	public List<employee> getEmployee(@Valid @RequestBody employeeDto empDto)
	{
		return empService.getAllEmployee(empDto);
	}
	
	@DeleteMapping("/details/{id}")
	public ResponseEntity<?> deleteEmployee(@RequestBody Long empId)
	{

		empService.deleteEmployee(empId);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/details/{id}")
	public employee getEmployeeById(@Valid @RequestBody employeeDto empDto, Long empId)
	{
		return empService.getEmployeeById(empDto,empId);
	}
	
	@PutMapping("/details/{id}")
	public ResponseEntity<employee> updateEmployee(@Valid @RequestBody employeeDto empDto, @PathVariable(value="id") Long empId)
	{
		return empService.updateEmployee(empDto, empId);
		
	}
	
	
	
}

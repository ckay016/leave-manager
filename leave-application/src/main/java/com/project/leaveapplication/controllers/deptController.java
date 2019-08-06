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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.leaveapplication.Dto.departmentDto;
import com.project.leaveapplication.model.department;
import com.project.leaveapplication.repository.departmentRepository;
import com.project.leaveapplication.services.departmentService;

@RestController
@RequestMapping("/dept")
public class deptController 
{
	@Autowired
	departmentRepository depRepo;
	
	@Autowired
	departmentService depService;
	
	@PostMapping("/details")
	public department addDepartment(@Valid @RequestBody departmentDto depDto)
	{
		return depService.addDepartment(depDto);
	}
	
	@GetMapping("/details")
	public List<department> getDepartment(@Valid @RequestBody departmentDto depDto)
	{
		return depService.getAllDepartment(depDto);
	}
	
	@DeleteMapping("/details/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable(value = "id") Long deptId)
	{

		depService.deleteDepartment(deptId);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/details/{id}")
	public department getDepartmentById(@Valid Long deptId)
	{
		return depService.getDepartment(deptId);
	}
	
	@PutMapping("/details/{id}")
	public ResponseEntity<?> updateDepartment(@Valid @RequestBody departmentDto depDto, @PathVariable(value = "id") Long deptId)
	{
		depService.updateDepartment(deptId, depDto);
		return ResponseEntity.ok().build();
	}
	
}

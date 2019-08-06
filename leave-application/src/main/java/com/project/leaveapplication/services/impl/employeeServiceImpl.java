package com.project.leaveapplication.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.leaveapplication.Dto.employeeDto;
import com.project.leaveapplication.exceptions.ResourceNotFoundException;
import com.project.leaveapplication.model.department;
import com.project.leaveapplication.model.employee;
import com.project.leaveapplication.repository.departmentRepository;
import com.project.leaveapplication.repository.employeeRepository;
import com.project.leaveapplication.services.employeeService;

@Service
public class employeeServiceImpl implements employeeService
{
	@Autowired
	employeeRepository empRepo;
	
	@Autowired
	departmentRepository depRepo;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public employee addEmployee(employeeDto empDto) 
	{
		employee emp = new employee();
		emp.setEmpName(empDto.getEmpName());
		emp.setEmpId(empDto.getEmpId());
		department dept = depRepo.findById(empDto.getDeptId()).get();
		emp.setDept(dept);
		return empRepo.save(emp);
	}

	@Override
	public List<employee> getAllEmployee(employeeDto empDto) 
	{
		return empRepo.findAll();
	}

	@Override
	public employee getEmployeeById(employeeDto empDto, Long empId) 
	{
		employee emp = empRepo.findById(empDto.getEmpId()).orElseThrow(() -> new ResourceNotFoundException("Leave", "id", empId));
		return emp;
	}

	@Override
	public ResponseEntity<?> deleteEmployee(Long empId) 
	{
		empRepo.deleteById(empId);
		return null;
	}

	@Override
	public ResponseEntity<employee> updateEmployee(employeeDto empDto, Long empId) 
	{
		employee emp = empRepo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Leave", "id", empId));
		emp.setEmpName(empDto.getEmpName());
		emp.setEmpId(empDto.getEmpId());
		department dept = depRepo.findById(empDto.getDeptId()).get();
		emp.setDept(dept);
		empRepo.save(emp);
		return ResponseEntity.ok(emp);
	}
}

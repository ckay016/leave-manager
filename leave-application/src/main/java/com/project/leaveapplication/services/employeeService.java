package com.project.leaveapplication.services;

import java.util.List;

import org.hibernate.service.Service;
import org.springframework.http.ResponseEntity;

import com.project.leaveapplication.Dto.employeeDto;
import com.project.leaveapplication.model.employee;
public interface employeeService extends Service 
{
	public employee addEmployee(employeeDto empDto);
	public List<employee> getAllEmployee(employeeDto empDto);
	public employee getEmployeeById(employeeDto empDto,Long empId);
	public ResponseEntity<?> deleteEmployee(Long empId);
	public ResponseEntity<employee> updateEmployee(employeeDto empDto, Long empId);
}

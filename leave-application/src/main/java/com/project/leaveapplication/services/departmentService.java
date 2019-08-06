package com.project.leaveapplication.services;

import java.util.List;

import org.hibernate.service.Service;
import org.springframework.http.ResponseEntity;

import com.project.leaveapplication.Dto.departmentDto;
import com.project.leaveapplication.model.department;

public interface departmentService extends Service 
{
	public department addDepartment(departmentDto depDto);
	public ResponseEntity<?> deleteDepartment(Long deptId);
	public department getDepartment(Long deptId);
	public List<department> getAllDepartment(departmentDto depDto);
	public ResponseEntity<?> updateDepartment(Long deptId, departmentDto depDto);
}

package com.project.leaveapplication.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.leaveapplication.Dto.departmentDto;
import com.project.leaveapplication.exceptions.ResourceNotFoundException;
import com.project.leaveapplication.model.department;
import com.project.leaveapplication.repository.departmentRepository;
import com.project.leaveapplication.services.departmentService;
import java.util.List;

@Service
public class departmentServiceImpl implements departmentService{	
	@Autowired
	departmentRepository depRepo;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public department addDepartment(departmentDto depDto)
	{
		department dep = new department();
		dep.setDeptId(depDto.getDeptId());
		dep.setDeptName(depDto.getDeptName());
		return depRepo.save(dep);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public List<department> getAllDepartment(departmentDto depDto) 
	{
		return depRepo.findAll();
	}

	@Override
	public department getDepartment(Long deptId)
	{
		department dep = depRepo.findById(deptId).orElseThrow(() -> new ResourceNotFoundException("Leave", "id", deptId));
		return dep;
	}

	@Override
	public ResponseEntity<department> updateDepartment(Long deptId, departmentDto depDto) 
	{
		department dep = depRepo.findById(deptId).orElseThrow(() -> new ResourceNotFoundException("Leave", "id", deptId));
		dep.setDeptId(depDto.getDeptId());
		dep.setDeptName(depDto.getDeptName());
		depRepo.save(dep);
		return ResponseEntity.ok(dep);
	}

	@Override
	public ResponseEntity<?> deleteDepartment(Long deptId) 
	{
		depRepo.deleteById(deptId);
		return null;
	}
}

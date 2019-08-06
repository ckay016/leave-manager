package com.project.leaveapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.leaveapplication.model.employee;
@Repository
public interface employeeRepository extends JpaRepository<employee, Long> 
{
	
}

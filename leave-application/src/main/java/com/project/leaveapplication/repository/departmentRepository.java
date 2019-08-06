package com.project.leaveapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.leaveapplication.model.department;

@Repository
public interface departmentRepository extends JpaRepository<department, Long> {

}

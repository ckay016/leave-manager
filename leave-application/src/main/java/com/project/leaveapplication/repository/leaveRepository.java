package com.project.leaveapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.leaveapplication.model.leave;
@Repository
public interface leaveRepository extends JpaRepository<leave, Long> {

}

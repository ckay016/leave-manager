package com.project.leaveapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.project.leaveapplication.model.department;
import com.project.leaveapplication.model.employee;
import com.project.leaveapplication.model.leave;

@SpringBootApplication
public class LeaveApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext c = SpringApplication.run(LeaveApplication.class, args);
		
		employee e = c.getBean(employee.class);
		e.show();
		
		department d = c.getBean(department.class);
		d.show();
		
		leave l = c.getBean(leave.class);
		l.show();
	}

}

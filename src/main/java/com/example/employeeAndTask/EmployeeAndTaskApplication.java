package com.example.employeeAndTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EntityScan(basePackages = "com.example.employeeAndTask.model")
//@EnableJpaRepositories(basePackages = {"com.example.employeeAndTask.Repository.EmployeeRepo", "com.example.employeeAndTask.Repository.TaskRepo"})
//@ComponentScan(basePackages = "com.example.employeeAndTask")
public class EmployeeAndTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAndTaskApplication.class, args);
	}

}

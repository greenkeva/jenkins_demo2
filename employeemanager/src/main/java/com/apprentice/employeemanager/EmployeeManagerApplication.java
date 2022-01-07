package com.apprentice.employeemanager;

import com.apprentice.employeemanager.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class EmployeeManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagerApplication.class, args);
		Employee em = new Employee("Kim", "Redd", "kim@mail.com", "manager","3132000000", 70);
	}

}

package com.seleniumexpress.employeeapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.seleniumexpress.employeeapp.entity.Employee;
import com.seleniumexpress.employeeapp.repo.EmployeeRepository;
import com.seleniumexpress.employeeapp.service.EmployeeService;

@RestController
public class EmployeeController {
	
	EmployeeService employeeService;
	
	@GetMapping("/eployees/{id}")
	Employee getEmployeeDetails(@PathVariable int id){
		
		//db call -> employee 1
		Employee employee = employeeService.getEmployeeById(id);
		
		return employee;
	}

}

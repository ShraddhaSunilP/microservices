package com.seleniumexpress.employeeapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seleniumexpress.employeeapp.entity.Employee;
import com.seleniumexpress.employeeapp.repo.EmployeeRepository;
import com.seleniumexpress.employeeapp.response.EmployeeResponse;

@Service
public class EmployeeService {
	
	@Autowired
    private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public EmployeeResponse getEmployeeById(int id) {
		
		Employee employee = employeeRepository.findById(id).orElse(null);
		EmployeeResponse employeeResponse= modelMapper.map(employee,EmployeeResponse.class);
		
		return employeeResponse;
	}
}

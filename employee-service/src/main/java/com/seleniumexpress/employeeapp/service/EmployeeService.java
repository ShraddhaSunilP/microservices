package com.seleniumexpress.employeeapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.seleniumexpress.employeeapp.entity.Employee;
import com.seleniumexpress.employeeapp.repo.EmployeeRepository;
import com.seleniumexpress.employeeapp.response.AddressResponse;
import com.seleniumexpress.employeeapp.response.EmployeeResponse;

@Service
public class EmployeeService {
	
	@Autowired
    private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// fill data in address response for that make rest api call
	private RestTemplate restTemplate;
	

	public EmployeeService(@Value("${addressservice.base.url}") String addressBaseUrl, RestTemplateBuilder builder){
		this.restTemplate = builder
							.rootUri(addressBaseUrl) 
							.build();
	}

	
	public EmployeeResponse getEmployeeById(int id) {
		
		Employee employee = employeeRepository.findById(id).orElse(null);
		
		EmployeeResponse employeeResponse= modelMapper.map(employee,EmployeeResponse.class);
		
		// get the address response data // restTemplate.getForObject(url, responseObject, urivariable);
		AddressResponse addressResponse = restTemplate.getForObject("/address/{id}", AddressResponse.class, id);
		
		//set addressResponse in employeeResponse
		employeeResponse.setAddressResponse(addressResponse);
		
		return employeeResponse;
	}
}

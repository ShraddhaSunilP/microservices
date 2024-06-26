package com.seleniumexpress.addressapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seleniumexpress.addressapp.entity.Address;
import com.seleniumexpress.addressapp.repository.AddressRepository;
import com.seleniumexpress.addressapp.response.AddressResponse;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public AddressResponse findAddressByEmployeeId(int employeeId) {
		
		Address address = addressRepository.findAddressByEmployeeId(employeeId);
		
		AddressResponse addressResponse = modelMapper.map(address, AddressResponse.class);
	
		return addressResponse;
	}
	
}

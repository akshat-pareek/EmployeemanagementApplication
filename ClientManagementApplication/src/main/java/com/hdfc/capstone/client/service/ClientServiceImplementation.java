package com.hdfc.capstone.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hdfc.capstone.client.config.AESDecryption;
import com.hdfc.capstone.client.dto.EmployeeDTO;
import com.hdfc.capstone.client.exception.EmployeeNotFoundException;
import com.hdfc.capstone.client.exception.InvalidEmployeeIdException;

@Service
public class ClientServiceImplementation implements IClientService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String baseUrl="https://localhost:8181/employee/getById/";
	
	@Override
	public EmployeeDTO getEmployee(long employeeId) throws Exception {
		 EmployeeDTO employeeDto = restTemplate.getForObject(baseUrl + employeeId, EmployeeDTO.class);
	        try {
				if(employeeDto==null) {
					throw new EmployeeNotFoundException("Employee not found with ID: " + employeeId);
				}
				employeeDto.setDateOfBirth(AESDecryption.decrypt(employeeDto.getDateOfBirth()));
				return employeeDto;
			}catch(NumberFormatException exc) {
				throw new InvalidEmployeeIdException("Provide the employeeId in long format only");
			}
	}

}

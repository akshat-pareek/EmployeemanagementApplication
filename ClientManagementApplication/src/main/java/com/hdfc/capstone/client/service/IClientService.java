package com.hdfc.capstone.client.service;

import com.hdfc.capstone.client.dto.EmployeeDTO;

public interface IClientService {
	
	public EmployeeDTO getEmployee(long employeeId) throws Exception;
}

package com.hdfc.capstone.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.capstone.employeemanagement.configure.AESEncryptiion;
import com.hdfc.capstone.employeemanagement.dto.EmployeeDTO;
import com.hdfc.capstone.employeemanagement.entity.Employee;
import com.hdfc.capstone.employeemanagement.exception.EmployeeNotFoundException;
import com.hdfc.capstone.employeemanagement.exception.InvalidEmployeeIdException;
import com.hdfc.capstone.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements IEmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeDTO getEmployeeByEmployeeID(long employeeId) throws Exception {
		
		try {
			Employee employee=employeeRepository.findById(employeeId).
					orElseThrow(()->new EmployeeNotFoundException("Employee not found with Id:"+employeeId));

			EmployeeDTO employeeDto=new EmployeeDTO();
			employeeDto.setEmployeeId(employeeId);
			employeeDto.setEmployeeName(employee.getEmployeeName());
			employeeDto.setDateOfBirth(AESEncryptiion.encrypt(employee.getDateOfBirth().toString()));

			return employeeDto;
		}catch(NumberFormatException exc) {
			throw new InvalidEmployeeIdException("Provide the employeeId in long format only");
		}
	}
	
}

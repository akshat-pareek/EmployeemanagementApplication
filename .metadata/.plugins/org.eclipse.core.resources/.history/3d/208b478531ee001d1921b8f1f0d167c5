package com.hdfc.capstone.employeemanagement.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.capstone.employeemanagement.dto.EmployeeDTO;
import com.hdfc.capstone.employeemanagement.exception.InvalidEmployeeIdException;
import com.hdfc.capstone.employeemanagement.service.IEmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);
	
	@GetMapping("/getById/{employeeId}")
	public EmployeeDTO getEmployee(@PathVariable long employeeId) throws Exception{
		try {
			logger.info("EmployeeId: "+employeeId);
			return employeeService.getEmployeeByEmployeeID(employeeId);
		}catch(NumberFormatException exc) {
			throw new InvalidEmployeeIdException("Provide the employeeId in long format only");
		}
	}
	
	@RequestMapping(value="/endpoint", method=RequestMethod.OPTIONS)
	public ResponseEntity<?> handleRequest(){
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("Allow","GET,OPTIONS");
		headers.add("Access-Control-Allow-Headers","GET,OPTIONS");
		headers.add("Access-Control-Allow-Headers","Content-Type,Authorization");
		return new ResponseEntity<>(headers,HttpStatus.OK);
	}
	
}

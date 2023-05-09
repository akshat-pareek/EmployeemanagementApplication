package com.hdfc.capstone.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.capstone.client.dto.EmployeeDTO;
import com.hdfc.capstone.client.service.IClientService;

@RestController
@RequestMapping("/client")
public class ClientRestController {
	
	@Autowired
	private IClientService clientService;
	
	@GetMapping("/getById/{employeeID}")
    public EmployeeDTO getEmployeeById(@PathVariable long employeeID) throws Exception {
        return clientService.getEmployee(employeeID);
    }
}

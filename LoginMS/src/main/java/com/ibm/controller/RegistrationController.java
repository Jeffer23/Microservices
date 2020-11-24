package com.ibm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.dto.LoginRequest;
import com.ibm.service.RegistrationService;

@RestController
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private RegistrationService service;
	
	@PostMapping("/user")
	public String regiterUser(@RequestBody LoginRequest req) {
		return service.registerUser(req);
	}
}

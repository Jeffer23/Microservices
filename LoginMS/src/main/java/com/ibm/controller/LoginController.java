package com.ibm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.dto.LoginRequest;
import com.ibm.dto.LoginResponse;
import com.ibm.service.LoginService;

@RestController
@RequestMapping("/user")
public class LoginController {

	@Autowired
	LoginService service;
	
	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest req) {
		return this.service.login(req);
	}
}

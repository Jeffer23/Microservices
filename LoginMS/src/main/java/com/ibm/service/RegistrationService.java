package com.ibm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.dao.UserDAO;
import com.ibm.dto.LoginRequest;

@Service
public class RegistrationService {

	
	@Autowired
	private UserDAO user;
	
	public String registerUser(LoginRequest request) {
		
		if(this.user.register(request.getUserName(), request.getPassword())) {
			return "Registration successful";
		}
		
		return "Registration failed";
	}
}

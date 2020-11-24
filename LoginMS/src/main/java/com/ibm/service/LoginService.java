package com.ibm.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.dao.UserDAO;
import com.ibm.dto.LoginRequest;
import com.ibm.dto.LoginResponse;
import com.ibm.token.JWT;

@Service
public class LoginService {

	@Autowired
	private  UserDAO userDB;
	
	public LoginResponse login(LoginRequest request) {
		boolean isLoginSuccess = this.userDB.login(request.getUserName(), request.getPassword());
		
		if(isLoginSuccess) {
			LoginResponse response = new LoginResponse();
			response.setJwtToken(JWT.create(UUID.randomUUID().toString(), "ISA_JEF", "JEF_SUB", 1800000L));
			response.setTransactionToken(UUID.randomUUID().toString());
			response.setUserName(request.getUserName());
			
			return response;
		}
		
		return null;
	}
}

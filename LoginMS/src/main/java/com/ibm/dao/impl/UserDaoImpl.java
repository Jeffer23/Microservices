package com.ibm.dao.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibm.dao.UserDAO;
import com.ibm.entities.User;
import com.ibm.repo.UserRepository;

@Repository
public class UserDaoImpl implements UserDAO {

	//private static Map<String, String> loginDB = new HashMap<String, String>();
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public boolean login(String userName, String password) {
		Optional<User> optionalUser = this.userRepo.findById(userName);
		if(optionalUser.isPresent()) {
			if(optionalUser.get().getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean register(String userName, String password) {
		Optional<User> optionalUser = this.userRepo.findById(userName);
		if(!optionalUser.isPresent()) {
			User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			
			this.userRepo.save(user);
			return true;
		}
		return false;
	}

}

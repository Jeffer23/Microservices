package com.ibm.dao;

public interface UserDAO {

	public boolean login(String userName, String password);
	
	public boolean register(String userName, String password);
}

package com.seniorsteps.repository;


import com.seniorsteps.entities.User;


public interface UserRepository {
	
	
	public User create(User user);

	public User getByUsernameAndPassword(String username, String password);
	
}

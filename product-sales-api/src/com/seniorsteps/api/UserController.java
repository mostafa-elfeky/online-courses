package com.seniorsteps.api;


import com.seniorsteps.entities.User;
import com.seniorsteps.repository.UserRepository;
import com.seniorsteps.repository.impl.UserRepositoryImpl;

public class UserController {
	

	UserRepository repository = new UserRepositoryImpl();
	
	public User signup(User user) {
		return repository.create(user);
	}
	
	public User signin(String username, String password) {
		return repository.getByUsernameAndPassword(username, password);
	}

}

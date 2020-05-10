package com.seniorsteps.test;


import com.seniorsteps.entities.User;
import com.seniorsteps.repository.UserRepository;
import com.seniorsteps.repository.impl.UserRepositoryImpl;

public class UserRepositoryTest {
	
	static UserRepository repository = new UserRepositoryImpl();

	public static void main(String[] args) {
		
//		createUserTest();
		
		getUserTest();
		
	}

	public static void createUserTest() {
		
		User user = getDummyUser();
		
		User createdUser = repository.create(user);
		
		System.out.println(createdUser);
	}
	
	
	public static void getUserTest() {
		
		User user = repository.getByUsernameAndPassword("admin", "admin");
		System.out.println(user);
	}
	
	
	public static User getDummyUser() {
		
		User user = new User();
		user.setFirstname("Mostafa");
		user.setLastname("Elfeky");
		user.setUsername("admin");
		user.setPassword("admin");
		user.setAge(44);
		user.setAddress("egypt cairo");
		
		return user;
	}
	
}

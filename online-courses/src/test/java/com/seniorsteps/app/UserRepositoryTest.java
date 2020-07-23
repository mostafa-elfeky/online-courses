package com.seniorsteps.app;


import java.time.LocalDate;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.seniorsteps.app.models.User;
import com.seniorsteps.app.repository.UserRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@WebAppConfiguration
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	
//	@Ignore
	@Test
    public void testSaveUser() throws Exception {

		User user = userRepository.save(getDummyUser());
        System.out.println(" User Insert status: " + user);
	}
	
	@Test
	@Ignore
    public void testFetUserById() throws Exception {

		User user = userRepository.findById(1).get();
        System.out.println(" User: " + user);
	}
	
	@Test
	@Ignore
    public void testFetUserByUsername() throws Exception {

		User user = userRepository.findUserByUsername("mostafa@gmail.com");
        System.out.println(" User: " + user);
	}
	
	private User getDummyUser() {
		User user = new User();
		
		user.setFirstname("mostafa");
		user.setLastname("ahmed");
		user.setUsername("mostafa@gmail.com");
		user.setAddress("cairo, egypt");
		user.setAge(33);
		user.setBirthDate(LocalDate.of(1990, 01, 01));
		user.setPassword("P@ssw0rd");
		
		return user;
	}


	
}

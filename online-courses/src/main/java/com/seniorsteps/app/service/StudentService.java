package com.seniorsteps.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seniorsteps.app.filter.CourseFilter;
import com.seniorsteps.app.models.Course;
import com.seniorsteps.app.models.Student;
import com.seniorsteps.app.models.User;
import com.seniorsteps.app.repository.ContentRepository;
import com.seniorsteps.app.repository.CourseRepository;

@Service
public class StudentService {


	
	
	
	public Student save(Student student) {
		
		// save user first
		User user = student.getUser();
		
		// save user
		
		
		// save student with saved userId
		student.setUser(user);
		
		
		
		
		return null;
	}

	
	
	
}

package com.seniorsteps.app;



import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.seniorsteps.app.models.Student;
import com.seniorsteps.app.repository.StudentRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@WebAppConfiguration
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;
	
	
	@Ignore
	@Test
    public void testSaveStudent() throws Exception {

		Student student = studentRepository.save(getDummyStudent());
        System.out.println(" Student Insert status: " + student);
	}
	
	@Test
	@Ignore
    public void testFetStudentById() throws Exception {

		Student student = studentRepository.findById(1).get();
        System.out.println(" Student: " + student);
	}
	
	@Test
//	@Ignore
    public void testDeleteStudent() throws Exception {

		studentRepository.deleteById(1);
        System.out.println(" Student deleted: ");
	}
	
	@Test
	@Ignore
    public void testUpdateStudent() throws Exception {

		Student student = getDummyStudent();
		student.setId(1);
		
		Student updatedStudent = studentRepository.save(student);
        System.out.println(" Student updated: " + updatedStudent);
	}
	
	private Student getDummyStudent() {
		Student student = new Student();
		
		student.setName("mostafa");
		student.setEmail("mostafa@gmail.com");
		
		return student;
	}


	
}

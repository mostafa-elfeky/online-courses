package com.seniorsteps.app.repository;

import com.seniorsteps.app.filter.SearchFilter;
import com.seniorsteps.app.models.Student;

public interface StudentRepository {

	Student save(Student student);

	boolean deleteStudent(int studentId);

	boolean updateStudent(Student student);
	
	Student findStudentById(int studentId);

	Student listStudents(SearchFilter filter);

}
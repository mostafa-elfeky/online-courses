package com.seniorsteps.app.repository;

import java.util.List;

import com.seniorsteps.app.filter.CourseFilter;
import com.seniorsteps.app.models.Course;

public interface CourseRepository {

	Course save(Course course);

	boolean delete(int courseId);

	boolean update(Course course);
	
	Course findById(int courseId);

	List<Course> list(CourseFilter filter);

}
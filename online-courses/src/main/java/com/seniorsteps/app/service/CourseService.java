package com.seniorsteps.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seniorsteps.app.filter.CourseFilter;
import com.seniorsteps.app.models.Course;
import com.seniorsteps.app.repository.ContentRepository;
import com.seniorsteps.app.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired 
	private CourseRepository courseRepository;
	
	@Autowired 
	private ContentRepository contentRepository;
	
	
	
	public Course save(Course course) {
		return courseRepository.save(course);
	}

	@Transactional
	public void delete(int courseId) {

		contentRepository.deleteByCourseId(courseId);
		courseRepository.delete(courseId);
	}

	public boolean update(Course course) {
		return courseRepository.update(course);
	}
	
	public Course findById(int courseId) {
		return courseRepository.findById(courseId);
	}

	public List<Course> list(CourseFilter filter) {
		return courseRepository.list(filter);
	}
	
}

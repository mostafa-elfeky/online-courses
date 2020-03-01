package com.seniorsteps.app.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seniorsteps.app.filter.CourseFilter;
import com.seniorsteps.app.models.Course;
import com.seniorsteps.app.service.CourseService;



@RestController
@RequestMapping("/api/courses")
public class CourseApiController {

	@Autowired 
	private CourseService courseService;
	
	
	@GetMapping
	public List<Course> list(CourseFilter filter) {
		
		List<Course> courses = courseService.list(filter);
		
		return courses;
	} 
	

}

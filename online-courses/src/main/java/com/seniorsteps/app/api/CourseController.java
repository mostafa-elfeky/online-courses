package com.seniorsteps.app.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seniorsteps.app.filter.CourseFilter;
import com.seniorsteps.app.models.Course;
import com.seniorsteps.app.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

	@Autowired 
	private CourseService courseService;
	
	
	@GetMapping
	public List<Course> list(CourseFilter filter) {
		return courseService.list(filter);
	}
	
	@PostMapping
	public Course save(@RequestBody Course course) {
		
		return courseService.save(course);
	}

	@DeleteMapping("/{courseId}")
	public void delete(@PathVariable("courseId") int courseId) {
		courseService.delete(courseId);
	}

	@PutMapping
	public boolean update(@RequestBody Course course) {
		return courseService.update(course);
	}
	
	@GetMapping("/{courseId}")
	public Course findById(@PathVariable("courseId") int courseId) {
		return courseService.findById(courseId);
	}

}

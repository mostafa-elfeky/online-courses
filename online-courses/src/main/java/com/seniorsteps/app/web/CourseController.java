package com.seniorsteps.app.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.seniorsteps.app.filter.CourseFilter;
import com.seniorsteps.app.models.Course;
import com.seniorsteps.app.service.CourseService;
import com.seniorsteps.app.service.LookupLoader;

@Controller
@RequestMapping("/courses")
public class CourseController {

	@Autowired 
	private CourseService courseService;
	
	@Autowired 
	private LookupLoader loader;
	
	@GetMapping
	public ModelAndView list(CourseFilter filter) {
		
		ModelAndView mav = new ModelAndView("course/courses-list");
		
		if(filter == null) {
			filter = new CourseFilter();
		}
		
		List<Course> courses = courseService.list(filter);
		
		mav.addObject("courses", courses);
		mav.addObject("categories", loader.getCategoryPerId().values());
		mav.addObject("filter", filter);
		
		return mav;
	} 
	
	@GetMapping("/{courseId}")
	public ModelAndView details(@PathVariable("courseId") int courseId) {
		
		ModelAndView mav = new ModelAndView("course/course-detail");
		
		Course course = courseService.findById(courseId);
		
		mav.addObject("course", course);
		return mav;
	} 
	

}

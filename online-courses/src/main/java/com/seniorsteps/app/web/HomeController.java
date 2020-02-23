package com.seniorsteps.app.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.seniorsteps.app.service.CourseService;

@Controller
public class HomeController {

	@Autowired 
	private CourseService courseService;
	
	
	@GetMapping
	public String home() {
		return "index";
	}

}

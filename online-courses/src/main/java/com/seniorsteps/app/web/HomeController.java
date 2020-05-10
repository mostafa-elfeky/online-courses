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

	@GetMapping("/login")
	public String login() {
		return "auth/login";
	}
	
	@GetMapping("/403")
	public String authError() {
		return "error/403";
	}

	
}

package com.seniorsteps.app;


import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice("com.seniorsteps.app.web")
@Order(Ordered.LOWEST_PRECEDENCE)
public class WebExceptionHandler {
	
	
	@ExceptionHandler(AccessDeniedException.class)
    public ModelAndView handleForbiddenException(AccessDeniedException exp) {
		
		exp.printStackTrace();
		System.out.println("herer...");

		return new ModelAndView("error/403");
    }
	
}
package com.seniorsteps.app;


import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class WebGeneralExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	protected String handleEcption(Exception ex,
			WebRequest request) {
		
		System.out.println("general excp");
		ex.printStackTrace();
		
		return "error/500";
	}
	
}
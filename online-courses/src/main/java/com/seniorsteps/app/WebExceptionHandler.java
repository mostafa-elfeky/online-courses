package com.seniorsteps.app;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class WebExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	protected String handleEcption(Exception ex,
			WebRequest request) {
		ex.printStackTrace();
		return "error/500";
	}
	
}
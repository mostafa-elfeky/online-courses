package com.seniorsteps.filters;

import java.io.IOException;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class Logger
 */
@WebFilter("/*")
public class Logger implements Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		Set<Entry<String, String[]>> params = request.getParameterMap().entrySet();
		System.out.println("Recieving request for resource: " + httpRequest.getRequestURI());
		
		for (Entry<String, String[]> entry : params) {
			for (String value : entry.getValue()) {
				System.out.print(entry.getKey()  + " : ");
				System.out.println(value);
			}
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}

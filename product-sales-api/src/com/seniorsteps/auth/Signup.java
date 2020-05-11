package com.seniorsteps.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seniorsteps.entities.User;
import com.seniorsteps.repository.UserRepository;
import com.seniorsteps.repository.impl.UserRepositoryImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns={"/signup"})
public class Signup extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private UserRepository userRepository = new UserRepositoryImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
				
		User user = new User();
		user.setFirstname(request.getParameter("firstname"));
		user.setLastname(request.getParameter("lastname"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setAge(Integer.parseInt(request.getParameter("age")));
		user.setAddress(request.getParameter("address"));
		
		userRepository.create(user);
		
		request.setAttribute("message", "You are registered successfully");
		
		request.getRequestDispatcher("views/auth/login.jsp")
			   .include(request, response);
	}

}

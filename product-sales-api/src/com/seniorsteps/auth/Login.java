package com.seniorsteps.auth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seniorsteps.entities.User;
import com.seniorsteps.service.UserService;

/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns={"/login"})
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	UserService userService = new UserService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = userService.signin(username, password);
		
		if(user == null){
			request.setAttribute("message", "Invalid username or password");
			
			dispatcher = request.getRequestDispatcher("views/auth/login.jsp");
			dispatcher.include(request, response);
		} else {
			session.setAttribute("user", user);
			
			response.sendRedirect("secure/customers");
//			dispatcher = request.send("secure/customers");
//			dispatcher.forward(request, response);
		}
		
	}

}

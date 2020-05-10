package com.seniorsteps.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seniorsteps.entities.Customer;
import com.seniorsteps.service.CustomerService;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/secure/customers/add")
public class CustomerAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CustomerService customerService = new CustomerService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAddController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("hererrere");
		request.getRequestDispatcher("/views/customers/add-customer.jsp")
			.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Customer customer = new Customer();
		customer.setFirstName(request.getParameter("firstName"));
		customer.setLastName(request.getParameter("lastName"));
		customer.setPhone(request.getParameter("phone"));
		customer.setAddress(request.getParameter("address"));
		customer.setCity(request.getParameter("city"));
		customer.setState(request.getParameter("state"));
		customer.setPoints(Integer.parseInt(request.getParameter("points")));
		
		if(request.getParameter("birthDate") != null)
			customer.setBirthDate(LocalDate.parse(request.getParameter("birthDate"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		
		customerService.create(customer);
		response.sendRedirect(getServletContext().getContextPath() + "/secure/customers");
		
	}

}

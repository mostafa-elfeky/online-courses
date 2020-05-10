package com.seniorsteps.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seniorsteps.entities.Customer;
import com.seniorsteps.queries.CustomerQuery;
import com.seniorsteps.service.CustomerService;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/secure/customers")
public class CustomerViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CustomerService customerService = new CustomerService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerViewController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String customerId = request.getParameter("customerId");
		
		if(customerId == null) {
			
			CustomerQuery query = new CustomerQuery();
			query.setKeyword(request.getParameter("keyword"));
			query.setCount(15);
			
			List<Customer> customers = customerService.list(query).getCustomers();
			
			request.setAttribute("customers", customers);
			request.getRequestDispatcher("/views/customers/list-customers.jsp")
				.forward(request, response);
		} else {
			
			Customer customer = customerService.get(Integer.parseInt(customerId));
						
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("/views/customers/customer-details.jsp")
			   .forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String customerId = request.getParameter("customerId");
		
		if(customerId == null) {

			request.setAttribute("message", "Not found!");
			response.sendRedirect(getServletContext().getContextPath() + "/secure/customers");
		} else {
			request.setAttribute("message", "Customer with ID " + customerId + " deleted successfully..");
			customerService.delete(Integer.parseInt(customerId));
			response.sendRedirect(getServletContext().getContextPath() + "/secure/customers");
		}
		
	}

}

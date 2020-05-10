package com.seniorsteps.api;


import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.seniorsteps.entities.Customer;
import com.seniorsteps.queries.CustomerQuery;
import com.seniorsteps.response.CustomerListResponse;
import com.seniorsteps.service.CustomerService;

@Path("/secure/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerController {
	
	CustomerService customerService = new CustomerService();

	@GET
	public CustomerListResponse list(@BeanParam CustomerQuery customerQuery) {
		return customerService.list(customerQuery);
	}

	@POST
	public Customer create(Customer customer) {
		return customerService.create(customer);
	}

	@PUT
	public Customer update(Customer customer) {
		return customerService.update(customer);
	}

	@DELETE
	public boolean delete(int customerId) {
		return customerService.delete(customerId);
	}

	@GET
	@Path("/{customerId}")
	public Customer get(@PathParam("customerId") int customerId) {
		return customerService.get(customerId);
	}

}

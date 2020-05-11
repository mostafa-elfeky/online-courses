package com.seniorsteps.api;


import java.util.List;

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
import com.seniorsteps.repository.CustomerRepository;
import com.seniorsteps.repository.impl.CustomerRepositoryImpl;

@Path("/secure/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerController {
	
	CustomerRepository customerRepository = new CustomerRepositoryImpl();

	@GET
	public List<Customer> list(@BeanParam CustomerQuery customerQuery) {
		return customerRepository.list(customerQuery);
	}

	@POST
	public Customer create(Customer customer) {
		return customerRepository.create(customer);
	}

	@PUT
	public Customer update(Customer customer) {
		return customerRepository.update(customer);
	}

	@DELETE
	public boolean delete(int customerId) {
		return customerRepository.delete(customerId);
	}

	@GET
	@Path("/{customerId}")
	public Customer get(@PathParam("customerId") int customerId) {
		return customerRepository.get(customerId);
	}

}

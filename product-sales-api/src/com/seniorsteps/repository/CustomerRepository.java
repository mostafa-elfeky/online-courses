package com.seniorsteps.repository;

import java.util.List;

import com.seniorsteps.entities.Customer;
import com.seniorsteps.queries.CustomerQuery;


public interface CustomerRepository {

	public Customer create(Customer customer);
	
	public Customer update(Customer customer);
	
	public boolean delete(int customerId);
	
	public Customer get(int customerId);
	
	public List<Customer> list(CustomerQuery customerQuery);
	
}

package com.seniorsteps.service;


import java.util.List;

import com.seniorsteps.entities.Customer;
import com.seniorsteps.queries.CustomerQuery;
import com.seniorsteps.repository.CustomerRepository;
import com.seniorsteps.repository.impl.CustomerRepositoryImpl;
import com.seniorsteps.response.CustomerListResponse;

public class CustomerService {
	

	CustomerRepository repository = new CustomerRepositoryImpl();

	
	public Customer create(Customer customer) {
		return repository.create(customer);
	}

	public Customer update(Customer customer) {
		return repository.update(customer);
	}

	public boolean delete(int customerId) {
		return repository.delete(customerId);
	}

	public Customer get(int customerId) {
		return repository.get(customerId);
	}

	public CustomerListResponse list(CustomerQuery customerQuery) {
		
		CustomerListResponse response = new CustomerListResponse();
		
		if(customerQuery.getCount() == 0) {
			customerQuery.setCount(10);
		}
		
		List<Customer> customers = repository.list(customerQuery);
		
		response.setCustomers(customers);
		return response;
	}


}

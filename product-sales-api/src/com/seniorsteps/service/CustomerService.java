package com.seniorsteps.service;


import java.util.List;

import com.seniorsteps.entities.Customer;
import com.seniorsteps.queries.CustomerQuery;
import com.seniorsteps.repository.CustomerRepository;
import com.seniorsteps.repository.impl.CustomerRepositoryImpl;

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

	public List<Customer> list(CustomerQuery customerQuery) {
		return repository.list(customerQuery);
	}


}

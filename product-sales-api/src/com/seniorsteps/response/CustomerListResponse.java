package com.seniorsteps.response;

import java.util.List;

import com.seniorsteps.entities.Customer;

public class CustomerListResponse {

	private List<Customer> customers;

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "CustomerListResponse [customers=" + customers + "]";
	}
	
}

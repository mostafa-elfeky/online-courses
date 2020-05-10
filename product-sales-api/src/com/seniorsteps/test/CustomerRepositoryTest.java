package com.seniorsteps.test;

import java.time.LocalDate;
import java.util.List;

import com.seniorsteps.entities.Customer;
import com.seniorsteps.queries.CustomerQuery;
import com.seniorsteps.repository.CustomerRepository;
import com.seniorsteps.repository.impl.CustomerRepositoryImpl;

public class CustomerRepositoryTest {
	
	static CustomerRepository repository = new CustomerRepositoryImpl();

	public static void main(String[] args) {
		
//		createCustomerTest();
		
//		updateCustomersTest();
		
//		deleteCustomerTest();
		
		getCustomerTest();
		
//		listCustomersTest();

	}

	public static void createCustomerTest() {
		
		Customer customer = getDummyCustomer();
		
		Customer createdCustomer = repository.create(customer);
		
		System.out.println(createdCustomer);
	}
	
	public static void updateCustomersTest() {
		
		Customer customer = getDummyCustomer();
		customer.setCustomerId(11);
		customer.setFirstName("Customer Name");
		Customer createdCustomer = repository.update(customer);
		
		System.out.println(createdCustomer);
		
	}
	
	public static void deleteCustomerTest() {
	
		Boolean deleted = repository.delete(11);
		System.out.println("Deleted: " + deleted);
		
	}
	
	public static void getCustomerTest() {
		
		Customer customer = repository.get(2);
		System.out.println(customer);
	}
	
	public static void listCustomersTest() {
		CustomerQuery query = new CustomerQuery();
		query.setKeyword("wi");
		query.setCount(10);
		List<Customer> customers = repository.list(query);
		System.out.println(customers);
	}
	
	public static Customer getDummyCustomer() {
		
		Customer customer = new Customer();
		customer.setFirstName("Mostafa");
		customer.setLastName("Elfeky");
		customer.setBirthDate(LocalDate.of(1994, 1, 25));
		customer.setPhone("01016621856");
		customer.setAddress("egypt cairo");
		customer.setCity("Madiet Nser");
		customer.setState("CA");
		customer.setPoints(112);
		
		return customer;
	}
	
}

package com.seniorsteps.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.seniorsteps.entities.Customer;
import com.seniorsteps.entities.Order;
import com.seniorsteps.entities.OrderItem;
import com.seniorsteps.entities.Product;
import com.seniorsteps.entities.Status;
import com.seniorsteps.queries.CustomerQuery;
import com.seniorsteps.repository.CustomerRepository;
import com.seniorsteps.util.DBConnection;



public class CustomerRepositoryImpl implements CustomerRepository {
	

	@Override
	public Customer create(Customer customer) {
		
		String query  = "INSERT INTO customers(first_name, last_name, birth_date, phone, "
				+ " address, city, state, points) "
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try (
			 Connection conn = DBConnection.getInstance().connect();
			 PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		){	
			stmt.setString(1, customer.getFirstName());	
			stmt.setString(2, customer.getLastName());	
			stmt.setObject(3, customer.getBirthDate());	
			stmt.setString(4, customer.getPhone());	
			stmt.setString(5, customer.getAddress());	
			stmt.setString(6, customer.getCity());	
			stmt.setString(7, customer.getState());	
			stmt.setInt(8, customer.getPoints());	
			
			stmt.executeUpdate();
			
			ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next())
                customer.setCustomerId(rs.getInt(1));
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return customer;
	}

	@Override
	public Customer update(Customer customer) {

		String query  = "UPDATE customers SET first_name= ?, last_name= ?,"
				+ " birth_date= ?, phone= ?, address= ?, city= ?, state=?, points= ? "
				+ " WHERE customer_id= ?";
		
		try (
			 Connection conn = DBConnection.getInstance().connect();
			 PreparedStatement stmt = conn.prepareStatement(query);
		){	
			stmt.setString(1, customer.getFirstName());	
			stmt.setString(2, customer.getLastName());	
			stmt.setObject(3, customer.getBirthDate());	
			stmt.setString(4, customer.getPhone());	
			stmt.setString(5, customer.getAddress());	
			stmt.setString(6, customer.getCity());	
			stmt.setString(7, customer.getState());	
			stmt.setInt(8, customer.getPoints());
			stmt.setInt(9, customer.getCustomerId());
			
			stmt.executeUpdate();
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return customer;
	}
	
	@Override
	public boolean delete(int customerId) {
		
		boolean deleted = false;
		
		String query  = "DELETE FROM customers WHERE customer_id= ?";
		
		try (
			 Connection conn = DBConnection.getInstance().connect();
			 PreparedStatement stmt = conn.prepareStatement(query);
		){	
			stmt.setInt(1, customerId);	
			deleted = stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return deleted;
	}

	@Override
	public Customer get(int customerId) {
		
		Customer customer = new Customer();
		
		String query  = "SELECT c.customer_id, c.first_name, c.last_name, c.birth_date, c.phone, "
				+ " c.address, c.city, c.state, c.points,"
				+ " o.order_id, o.order_date, o.shipped_date, o.status,"
				+ " i.quantity, i.unit_price,"
				+ " p.product_id, p.name "
				+ " FROM customers c "
				+ " LEFT JOIN orders o on c.customer_id = o.customer_id "
				+ " LEFT JOIN order_items i on o.order_id = i.order_id "
				+ " LEFT JOIN products p on i.product_id = p.product_id "
				+ " WHERE c.customer_id = ?";
		
		try (
			 Connection conn = DBConnection.getInstance().connect();
			 PreparedStatement stmt = conn.prepareStatement(query);
		){	
			stmt.setInt(1, customerId);	
			ResultSet rs = stmt.executeQuery();
			
			customer = extractCustomer(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public List<Customer> list(CustomerQuery customerQuery) {


		StringBuilder query  = new StringBuilder();
		List<Customer> customers = new ArrayList<Customer>();
		int index = 0;
		
		query.append("SELECT customer_id, first_name, last_name, birth_date, phone, "
				+ " address, city, state, points FROM customers "
				+ "WHERE 1=1 ");
		
		if(customerQuery.getKeyword() != null) {
			query.append(" AND (first_name LIKE ? OR last_name LIKE ? )");
		}
		
		if(customerQuery.getBirthdate() != null) {
			query.append(" AND birth_date= ?");
		}
		
		query.append("LIMIT ?, ?");
		
		try (
			 Connection conn = DBConnection.getInstance().connect();
			 PreparedStatement stmt = conn.prepareStatement(query.toString());
		){	

			if(customerQuery.getKeyword() != null) {
				stmt.setString(++index, customerQuery.getKeyword());
				stmt.setString(++index, customerQuery.getKeyword());
			}
			
			if(customerQuery.getBirthdate() != null) {
				stmt.setObject(++index, customerQuery.getBirthdate());
			}
			
			stmt.setInt(++index, customerQuery.getStart());	
			stmt.setInt(++index, customerQuery.getCount());
			
			ResultSet rs = stmt.executeQuery();
			
			customers = extractCustomers(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return customers;
	}
	
	private List<Customer> extractCustomers(ResultSet rs) throws SQLException {
		
		List<Customer> customers = new ArrayList<Customer>();
		
		while(rs.next()) {
			Customer customer = new Customer();
			customer.setCustomerId(rs.getInt("customer_id"));
			customer.setFirstName(rs.getString("first_name"));
			customer.setLastName(rs.getString("last_name"));
			customer.setBirthDate(rs.getObject("birth_date", LocalDate.class));
			customer.setPhone(rs.getString("phone"));
			customer.setAddress(rs.getString("address"));
			customer.setCity(rs.getString("city"));
			customer.setState(rs.getString("state"));
			customer.setPoints(rs.getInt("points"));
			customers.add(customer);
		}
		
		return customers;
	}
	
	
	private Customer extractCustomer(ResultSet rs) throws SQLException {
		
		Customer customer = new Customer();
		Map<Integer, Order> orders = new HashMap<Integer, Order>();
		
		while(rs.next()) {
			
			customer.setCustomerId(rs.getInt("c.customer_id"));
			customer.setFirstName(rs.getString("c.first_name"));
			customer.setLastName(rs.getString("c.last_name"));
			customer.setBirthDate(rs.getObject("c.birth_date", LocalDate.class));
			customer.setPhone(rs.getString("c.phone"));
			customer.setAddress(rs.getString("c.address"));
			customer.setCity(rs.getString("c.city"));
			customer.setState(rs.getString("c.state"));
			customer.setPoints(rs.getInt("c.points"));
			
			Integer orderId = rs.getInt("o.order_id");
			
			if(orderId != null) {
				Order order = orders.get(orderId);
				
				if(order == null) {
					order = new Order();
					order.setOrderId(rs.getInt("o.order_id"));
					order.setStatus(new Status(rs.getInt("o.status")));
					order.setShippedDate(rs.getObject("o.shipped_date", LocalDateTime.class));
					order.setOrderDate(rs.getObject("o.order_date", LocalDateTime.class));
					order.setItems(new ArrayList<>());
					orders.put(order.getOrderId(), order);
				}
				
				OrderItem item = new OrderItem();
				item.setPrice(rs.getDouble("i.unit_price"));
				item.setQuanntity(rs.getInt("i.quantity"));
				
				Product product = new Product();
				product.setProductId(rs.getInt("p.product_id"));
				product.setName(rs.getString("p.name"));
				
				item.setProduct(product);
				
				order.getItems().add(item);
			}
			
			if(!orders.isEmpty())
				customer.setOrders(new ArrayList<>(orders.values()));
		}
		
		return customer;
	}

}

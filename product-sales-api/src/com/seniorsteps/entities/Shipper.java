package com.seniorsteps.entities;

import java.util.List;

public class Shipper {

	private int shipperId;
	private String name;
	
	private List<Order> orders;
	
	public int getShipperId() {
		return shipperId;
	}
	public void setShipperId(int shipperId) {
		this.shipperId = shipperId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Shipper [shipperId=" + shipperId + ", name=" + name + ", orders=" + orders + "]";
	}
	
}

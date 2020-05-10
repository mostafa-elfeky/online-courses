package com.seniorsteps.entities;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

	private int orderId;
	private LocalDateTime orderDate;
	private LocalDateTime shippedDate;
	private String comments;
	
	private Customer customer;
	private Shipper shipper;
	private Status status;
	private List<OrderItem> items;
	
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public LocalDateTime getShippedDate() {
		return shippedDate;
	}
	public void setShippedDate(LocalDateTime shippedDate) {
		this.shippedDate = shippedDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Shipper getShipper() {
		return shipper;
	}
	public void setShipper(Shipper shipper) {
		this.shipper = shipper;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + orderId + ", orderDate=" + orderDate + ", shippedDate=" + shippedDate
				+ ", comments=" + comments + ", customer=" + customer + ", shipper=" + shipper + ", status=" + status
				+ ", items=" + items + "]";
	}
	
	
	
	
}

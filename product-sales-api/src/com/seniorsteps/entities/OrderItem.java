package com.seniorsteps.entities;

public class OrderItem {

	private int quanntity;
	private double price;
	
	private Product product;
	private Order order;
	
	
	public int getQuanntity() {
		return quanntity;
	}
	public void setQuanntity(int quanntity) {
		this.quanntity = quanntity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "OrderItem [quanntity=" + quanntity + ", price=" + price + ", product=" + product + ", order=" + order
				+ "]";
	}
	
	
	
	
}

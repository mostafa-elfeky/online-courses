package com.seniorsteps.entities;

import java.util.List;

public class Product {

	private int productId;
	private String code;
	private String name;
	private int quanntity;
	private double price;
	
	private Supplier supplier;
	private ProductDetails details;
	private List<OrderItem> items;
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public ProductDetails getDetails() {
		return details;
	}
	public void setDetails(ProductDetails details) {
		this.details = details;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", code=" + code + ", name=" + name + ", quanntity=" + quanntity
				+ ", price=" + price + ", supplier=" + supplier + ", details=" + details + ", items=" + items + "]";
	}
	
	
	
}

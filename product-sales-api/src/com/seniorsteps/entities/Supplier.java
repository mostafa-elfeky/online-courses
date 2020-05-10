package com.seniorsteps.entities;

import java.util.List;

public class Supplier {

	private int supplier_id;
	private String name;
	private List<Product> products;
	

	public Supplier() {}
	
	public Supplier(int supplier_id, String name) {
		super();
		this.supplier_id = supplier_id;
		this.name = name;
	}
	
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Supplier [supplier_id=" + supplier_id + ", name=" + name + "]";
	}
	
}

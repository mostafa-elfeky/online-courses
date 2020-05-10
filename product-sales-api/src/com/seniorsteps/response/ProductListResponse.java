package com.seniorsteps.response;

import java.util.List;

import com.seniorsteps.entities.Product;

public class ProductListResponse {

	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "ProductListResponse [products=" + products + "]";
	}
	
}

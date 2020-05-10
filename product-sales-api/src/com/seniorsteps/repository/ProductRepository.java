package com.seniorsteps.repository;

import java.util.List;

import com.seniorsteps.entities.Product;
import com.seniorsteps.queries.ProductQuery;


public interface ProductRepository {

	public Product create(Product product);
	
	public Product update(Product product);
	
	public boolean delete(int productId);
	
	public Product get(int productId);
	
	public List<Product> list(ProductQuery productQuery);
	
}

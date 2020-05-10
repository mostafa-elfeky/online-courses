package com.seniorsteps.service;


import java.util.List;

import com.seniorsteps.entities.Product;
import com.seniorsteps.queries.ProductQuery;
import com.seniorsteps.repository.ProductRepository;
import com.seniorsteps.repository.impl.ProductRepositoryImpl;
import com.seniorsteps.response.ProductListResponse;

public class ProductService {
	

	ProductRepository repository = new ProductRepositoryImpl();

	
	public Product create(Product product) {
		return repository.create(product);
	}

	public Product update(Product product) {
		return repository.update(product);
	}

	public boolean delete(int productId) {
		return repository.delete(productId);
	}

	public Product get(int productId) {
		return repository.get(productId);
	}

	public ProductListResponse list(ProductQuery productQuery) {
		
		ProductListResponse response = new ProductListResponse();
		
		if(productQuery.getCount() == 0) {
			productQuery.setCount(10);
		}
		
		List<Product> products = repository.list(productQuery);
		
		response.setProducts(products);
		return response;
	}


}

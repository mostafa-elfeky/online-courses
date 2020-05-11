package com.seniorsteps.api;


import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.seniorsteps.entities.Product;
import com.seniorsteps.queries.ProductQuery;
import com.seniorsteps.repository.ProductRepository;
import com.seniorsteps.repository.impl.ProductRepositoryImpl;

@Path("/secure/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductController {
	
	ProductRepository productRepository = new ProductRepositoryImpl();

	@GET
	public List<Product> list(@BeanParam ProductQuery productQuery) {
		return productRepository.list(productQuery);
	}

	@POST
	public Product create(Product product) {
		return productRepository.create(product);
	}

	@PUT
	public Product update(Product product) {
		return productRepository.update(product);
	}

	@DELETE
	public boolean delete(int productId) {
		return productRepository.delete(productId);
	}

	@GET
	@Path("/{productId}")
	public Product get(@PathParam("productId") int productId) {
		return productRepository.get(productId);
	}

}

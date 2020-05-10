package com.seniorsteps.api;


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
import com.seniorsteps.response.ProductListResponse;
import com.seniorsteps.service.ProductService;

@Path("/secure/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductController {
	
	ProductService productService = new ProductService();

	@GET
	public ProductListResponse list(@BeanParam ProductQuery productQuery) {
		return productService.list(productQuery);
	}

	@POST
	public Product create(Product product) {
		return productService.create(product);
	}

	@PUT
	public Product update(Product product) {
		return productService.update(product);
	}

	@DELETE
	public boolean delete(int productId) {
		return productService.delete(productId);
	}

	@GET
	@Path("/{productId}")
	public Product get(@PathParam("productId") int productId) {
		return productService.get(productId);
	}

}

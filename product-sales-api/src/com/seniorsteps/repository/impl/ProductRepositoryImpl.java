package com.seniorsteps.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.seniorsteps.entities.Product;
import com.seniorsteps.entities.Supplier;
import com.seniorsteps.queries.ProductQuery;
import com.seniorsteps.repository.ProductRepository;
import com.seniorsteps.util.DBConnection;



public class ProductRepositoryImpl implements ProductRepository {
	

	@Override
	public Product create(Product product) {
		
		String query  = "INSERT INTO products(product_code, name, quantity_in_stock, unit_price, supplier_id) "
				+ " VALUES (?, ?, ?, ?, ?)";
		
		try (
			 Connection conn = DBConnection.getInstance().connect();
			 PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		){	
			stmt.setString(1, product.getCode());	
			stmt.setString(2, product.getName());	
			stmt.setInt(3, product.getQuanntity());	
			stmt.setDouble(4, product.getPrice());	
			stmt.setLong(5, product.getSupplier().getSupplier_id());	
			
			stmt.executeUpdate();
			
			ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next())
                product.setProductId(rs.getInt(1));
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return product;
	}

	@Override
	public Product update(Product product) {

		String query  = "UPDATE products SET product_code= ?, name= ?,"
				+ " quantity_in_stock= ?, unit_price= ?, supplier_id= ? "
				+ " WHERE product_id= ?";
		
		try (
			 Connection conn = DBConnection.getInstance().connect();
			 PreparedStatement stmt = conn.prepareStatement(query);
		){	
			stmt.setString(1, product.getCode());	
			stmt.setString(2, product.getName());	
			stmt.setInt(3, product.getQuanntity());	
			stmt.setDouble(4, product.getPrice());	
			stmt.setLong(5, product.getSupplier().getSupplier_id());
			stmt.setInt(6, product.getProductId());
			
			stmt.executeUpdate();
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return product;
	}
	
	@Override
	public boolean delete(int productId) {
		
		boolean deleted = false;
		
		String query  = "DELETE FROM products WHERE product_id= ?";
		
		try (
			 Connection conn = DBConnection.getInstance().connect();
			 PreparedStatement stmt = conn.prepareStatement(query);
		){	
			stmt.setInt(1, productId);	
			deleted = stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return deleted;
	}

	@Override
	public Product get(int productId) {
		
		Product product = new Product();
		
		String query  = "SELECT p.product_id, p.product_code, p.name, p.quantity_in_stock,"
				+ " p.unit_price, s.supplier_id, s.name as 'supplier_name' "
				+ " FROM products p join suppliers s on (p.supplier_id = s.supplier_id)"
				+ " WHERE p.product_id = ?";
		
		try (
			 Connection conn = DBConnection.getInstance().connect();
			 PreparedStatement stmt = conn.prepareStatement(query);
		){	
			stmt.setInt(1, productId);	
			ResultSet rs = stmt.executeQuery();
			
			product = extractProduct(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public List<Product> list(ProductQuery productQuery) {


		StringBuilder query  = new StringBuilder();
		List<Product> products = new ArrayList<Product>();
		int index = 0;
		
		query.append("SELECT p.product_id, p.product_code, p.name, p.quantity_in_stock, "
				+ " p.unit_price, s.supplier_id, s.name as 'supplier_name' "
				+ " FROM products p join suppliers s on (p.supplier_id = s.supplier_id)"
				+ " WHERE 1=1 ");
		
		if(productQuery.getKeyword() != null) {
			query.append(" AND p.name LIKE ? ");
		}
		
		query.append("LIMIT ?, ?");
		
		System.out.println(query);
		
		try (
			 Connection conn = DBConnection.getInstance().connect();
			 PreparedStatement stmt = conn.prepareStatement(query.toString());
		){	

			if(productQuery.getKeyword() != null) {
				stmt.setString(++index, productQuery.getKeyword());
			}
			
			stmt.setInt(++index, productQuery.getStart());	
			stmt.setInt(++index, productQuery.getCount());
			
			ResultSet rs = stmt.executeQuery();
			
			products = extractProducts(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}
	
	private List<Product> extractProducts(ResultSet rs) throws SQLException {
		
		List<Product> products = new ArrayList<Product>();
		
		while(rs.next()) {
			Product product = new Product();
			product.setProductId(rs.getInt("p.product_id"));
			product.setCode(rs.getString("p.product_code"));
			product.setName(rs.getString("p.name"));
			product.setQuanntity(rs.getInt("p.quantity_in_stock"));
			product.setPrice(rs.getDouble("p.unit_price"));
			product.setSupplier(new Supplier(rs.getInt("s.supplier_id"), rs.getString("supplier_name")));
			products.add(product);
		}
		
		return products;
	}
	
	private Product extractProduct(ResultSet rs) throws SQLException {
		
		Product product = null;
		
		if(rs.next()) {
			product = new Product();
			product.setProductId(rs.getInt("p.product_id"));
			product.setCode(rs.getString("p.product_code"));
			product.setName(rs.getString("p.name"));
			product.setQuanntity(rs.getInt("p.quantity_in_stock"));
			product.setPrice(rs.getDouble("p.unit_price"));
			product.setSupplier(new Supplier(rs.getInt("s.supplier_id"), rs.getString("supplier_name")));
		}
		
		return product;
	}

}

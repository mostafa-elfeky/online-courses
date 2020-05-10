package com.seniorsteps.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.seniorsteps.entities.User;
import com.seniorsteps.repository.UserRepository;
import com.seniorsteps.util.DBConnection;



public class UserRepositoryImpl implements UserRepository {
	

	@Override
	public User create(User user) {
		
		String query  = "INSERT INTO user(firstname, lastname, username, password, age, address) "
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		
		try (
			 Connection conn = DBConnection.getInstance().connect();
			 PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		){	
			stmt.setString(1, user.getFirstname());	
			stmt.setString(2, user.getLastname());	
			stmt.setString(3, user.getUsername());	
			stmt.setString(4, user.getPassword());	
			stmt.setInt(5, user.getAge());	
			stmt.setString(6, user.getAddress());	
			
			stmt.executeUpdate();
			
			ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next())
                user.setUserId(rs.getInt(1));
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public User getByUsernameAndPassword(String username, String password) {

		User user = null;
		
		String query = "SELECT user_id, firstname, lastname, username, password, age, address "
				+ "FROM user WHERE username= ? AND password= ? ";
		
		try (
				 Connection conn = DBConnection.getInstance().connect();
				 PreparedStatement stmt = conn.prepareStatement(query);
			){	
				stmt.setString(1, username);	
				stmt.setString(2, password);	

				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()) {
					user = new User();
					user.setUserId(rs.getInt("user_id"));
					user.setFirstname(rs.getString("firstname"));
					user.setLastname(rs.getString("lastname"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					user.setAge(rs.getInt("age"));
					user.setAddress(rs.getString("address"));
				}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

}

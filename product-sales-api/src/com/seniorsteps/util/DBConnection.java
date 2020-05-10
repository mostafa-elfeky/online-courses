package com.seniorsteps.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	private static DBConnection connection = new DBConnection();
	
	
	public static DBConnection getInstance() {
		return connection;
	}
	
	
	public Connection connect() {
		
		Connection connection = null;
		Properties props = AppProps.getProps(); 
		try {
			
			Class.forName(props.getProperty("app.database.driver"));
			
			connection = DriverManager.getConnection( 
					props.getProperty("app.database.url"),
					props.getProperty("app.database.username"),
					props.getProperty("app.database.password"));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return connection;
	}
	
	
	
}

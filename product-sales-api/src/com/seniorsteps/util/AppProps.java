package com.seniorsteps.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppProps {

	public static Properties getProps() {
		
		Properties properties = new Properties();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
				
		try (InputStream input = classLoader.getResourceAsStream("com/seniorsteps/aplication.properties");) {
			
			properties.load(input);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

}

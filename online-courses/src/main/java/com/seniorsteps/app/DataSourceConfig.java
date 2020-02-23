package com.seniorsteps.app;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

    @Autowired
	Environment env;
    

    @Bean
	public DataSource getDataSource() {
		
		// create connection pool
    	BasicDataSource dataSource = new BasicDataSource();
				
		// set the jdbc driver class
    	dataSource.setDriverClassName(env.getProperty("database.driver"));
		
		// set database connection props
		dataSource.setUrl(env.getProperty("database.url"));
		dataSource.setUsername(env.getProperty("database.user.name"));
		dataSource.setPassword(env.getProperty("database.user.password"));
		dataSource.setValidationQuery("SELECT 1");
		// set connection pool props
		dataSource.setInitialSize(Integer.parseInt(env.getProperty("database.connection.initialPoolSize")));
		
		return dataSource;
	}
	
	@Bean
	public NamedParameterJdbcTemplate jdbcTemplate() {
	    return new NamedParameterJdbcTemplate(getDataSource());
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(){
	    return new DataSourceTransactionManager(getDataSource());
	}

}
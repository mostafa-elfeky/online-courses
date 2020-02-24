package com.seniorsteps.app.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.seniorsteps.app.models.User;
import com.seniorsteps.app.repository.UserRepository;
import com.seniorsteps.app.service.LookupLoader;


@Repository
public class UserRepositoryImpl implements UserRepository {


	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	private LookupLoader lookupLoader;
	
	
	@Override
	public User save(User user) {
		
		String query = "INSERT INTO user (first_name, last_name, username, password, age, address, birth_date) "
				+ "VALUES (:firstname, :lastname, :username, :password, :age, :address, :birthDate)";
			
		KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(user);
		
		int insertedRows = jdbcTemplate.update(query, namedParameters, generatedKeyHolder);
		
		if (insertedRows > 0) {
			user.setId(generatedKeyHolder.getKey().intValue());
		}

		return user;
	}


	@Override
	public User findUserByUsername(String username) {
		
		User user =  null;
		Map<String, Object> mapParameters = null;
		String query = " SELECT user.* FROM user WHERE user.username= :username";
		
		mapParameters = new HashMap<String, Object>();
		mapParameters.put("username", username);

		user = jdbcTemplate.queryForObject(query, mapParameters, new UserRowMapper());
		
		return user;
	}
	
	@Override
	public User findUserById(int userId) {
		
		User user =  null;
		Map<String, Object> mapParameters = null;
		String query = " SELECT user.* FROM user WHERE user.ID= :userId";
		
		mapParameters = new HashMap<String, Object>();
		mapParameters.put("userId", userId);

		user =  jdbcTemplate.queryForObject(query, mapParameters, new UserRowMapper());
		
		return user;
	}
	
	
	class UserRowMapper implements RowMapper<User> {
		
		@Override
		public User mapRow(ResultSet rs, int arg1) throws SQLException {
			User user = new User();
			
			user.setId(rs.getInt("user.ID"));
			user.setFirstname(rs.getString("user.first_name"));
			user.setLastname(rs.getString("user.last_name"));
			user.setUsername(rs.getString("user.username"));
			user.setAddress(rs.getString("user.address"));
			user.setAge(rs.getInt("user.age"));
			user.setBirthDate(rs.getObject("user.birth_date", LocalDate.class));
			user.setPassword(rs.getString("user.password"));
			user.setType(lookupLoader.getUserTypePerId().get(rs.getInt("user.user_type_id")));
			
			return user;
		}
	}
	
	
}

package com.seniorsteps.app.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.seniorsteps.app.models.Category;
import com.seniorsteps.app.models.Gender;
import com.seniorsteps.app.repository.GeneralRepository;


@Repository
public class GeneralRepositoryImpl implements GeneralRepository {

	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	

	@Override
	public List<Category> listCategories() {

		List<Category> categories = null;
		String query = " SELECT category.* FROM category";
		
		categories =  jdbcTemplate.query(query, new RowMapper<Category>() {

			@Override
			public Category mapRow(ResultSet rs, int arg1) throws SQLException {
				
				Category category = new Category();
				category.setId(rs.getInt("category.id"));
				category.setName(rs.getString("category.name"));
				category.setCode(rs.getString("category.code"));
				
				return category;
			}
		});
		
		return categories;
	}

	@Override
	public List<Gender> listGeneders() {
		
		List<Gender> genders = null;
		String query = " SELECT gender.* FROM gender";
		
		genders =  jdbcTemplate.query(query, new RowMapper<Gender>() {

			@Override
			public Gender mapRow(ResultSet rs, int arg1) throws SQLException {
				
				Gender gender = new Gender();
				gender.setId(rs.getInt("gender.id"));
				gender.setName(rs.getString("gender.name"));
				gender.setCode(rs.getString("gender.code"));
				
				return gender;
			}
		});
		
		return genders;
	}
	
}

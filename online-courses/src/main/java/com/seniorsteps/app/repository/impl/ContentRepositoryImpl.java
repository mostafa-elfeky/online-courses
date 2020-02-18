package com.seniorsteps.app.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.seniorsteps.app.filter.SearchFilter;
import com.seniorsteps.app.models.Content;
import com.seniorsteps.app.repository.ContentRepository;


@Repository
public class ContentRepositoryImpl implements ContentRepository {

	

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	
	@Override
	public Content save(Content content) {
		
		String query = "INSERT INTO content (first_name, last_name, email) "
				+ "VALUES (:firstname, :lastname, :email)";
			
		KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(content);
		
		int insertedRows = jdbcTemplate.update(query, namedParameters, generatedKeyHolder);
		
		if (insertedRows > 0) {
			content.setId(generatedKeyHolder.getKey().intValue());
		}

		return content;
	}
	
	@Override
	public Content findById(int contentId) {
		
		Content content =  null;
		Map<String, Object> mapParameters = null;
		String query = " SELECT content.* FROM content WHERE content.ID= :contentId";
		
		mapParameters = new HashMap<String, Object>();
		mapParameters.put("contentId", contentId);

		content =  jdbcTemplate.queryForObject(query, mapParameters, new ContentRowMapper());
		
		return content;
	}
	
	@Override
	public List<Content> list(SearchFilter filter) {
		
		List<Content> contents =  null;
		Map<String, Object> mapParameters = null;
		String query = " SELECT content.* FROM content WHERE content.first_name LIKE %:keyword%";
		
		mapParameters = new HashMap<String, Object>();
		mapParameters.put("keyword", filter.getKeyword());

		contents =  jdbcTemplate.query(query, mapParameters, new ContentRowMapper());
		
		return contents;
	}

	@Override
	public boolean delete(int contentId) {
		
		Map<String, Object> mapParameters = new HashMap<String, Object>();
		mapParameters.put("id", contentId);

		String query = "DELETE FROM content WHERE content.id= :id";
			
		int deletedRows = jdbcTemplate.update(query, mapParameters);
		
		return deletedRows > 0;
	}
	
	@Override
	public boolean deleteByCourseId(int courseId) {
		
		Map<String, Object> mapParameters = new HashMap<String, Object>();
		mapParameters.put("courseId", courseId);

		String query = "DELETE FROM content WHERE content.course_id= :courseId";
			
		int deletedRows = jdbcTemplate.update(query, mapParameters);
		
		return deletedRows > 0;
	}

	@Override
	public boolean update(Content content) {

		String query = "UPDATE content SET first_name= :firstname, last_name= :lastname, email= :email "
				+ " WHERE content.id= :id";
			
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(content);
		
		int updatedRows = jdbcTemplate.update(query, namedParameters);
		
		return updatedRows > 0;
	}
	
	class ContentRowMapper implements RowMapper<Content> {
			
			@Override
			public Content mapRow(ResultSet rs, int arg1) throws SQLException {
				
				Content content = new Content();
				
				content.setId(rs.getInt("content.ID"));
				
				return content;
			}
	}
	
}

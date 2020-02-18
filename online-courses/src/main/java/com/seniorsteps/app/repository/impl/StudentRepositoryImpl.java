package com.seniorsteps.app.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
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

import com.seniorsteps.app.filter.SearchFilter;
import com.seniorsteps.app.models.Student;
import com.seniorsteps.app.repository.StudentRepository;


@Repository
public class StudentRepositoryImpl implements StudentRepository {

	

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	
	@Override
	public Student save(Student student) {
		
		String query = "INSERT INTO student (first_name, last_name, email) "
				+ "VALUES (:firstname, :lastname, :email)";
			
		KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(student);
		
		int insertedRows = jdbcTemplate.update(query, namedParameters, generatedKeyHolder);
		
		if (insertedRows > 0) {
			student.setId(generatedKeyHolder.getKey().intValue());
		}

		return student;
	}
	
	@Override
	public Student findStudentById(int studentId) {
		
		Student student =  null;
		Map<String, Object> mapParameters = null;
		String query = " SELECT student.* FROM student WHERE student.ID= :studentId";
		
		mapParameters = new HashMap<String, Object>();
		mapParameters.put("studentId", studentId);

		student =  jdbcTemplate.queryForObject(query, mapParameters, new StudentRowMapper());
		
		return student;
	}
	
	@Override
	public Student listStudents(SearchFilter filter) {
		
		Student student =  null;
		Map<String, Object> mapParameters = null;
		String query = " SELECT student.* FROM student WHERE student.first_name LIKE %:keyword%";
		
		mapParameters = new HashMap<String, Object>();
		mapParameters.put("keyword", filter.getKeyword());

		student =  jdbcTemplate.queryForObject(query, mapParameters, new StudentRowMapper());
		
		return student;
	}

	@Override
	public boolean deleteStudent(int studentId) {
		
		Map<String, Object> mapParameters = new HashMap<String, Object>();
		mapParameters.put("id", studentId);

		String query = "DELETE FROM student WHERE student.id= :id";
			
		int deletedRows = jdbcTemplate.update(query, mapParameters);
		
		return deletedRows > 0;
	}

	@Override
	public boolean updateStudent(Student student) {

		String query = "UPDATE student SET first_name= :firstname, last_name= :lastname, email= :email "
				+ " WHERE student.id= :id";
			
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(student);
		
		int updatedRows = jdbcTemplate.update(query, namedParameters);
		
		return updatedRows > 0;
	}
	
	class StudentRowMapper implements RowMapper<Student> {
			
			@Override
			public Student mapRow(ResultSet rs, int arg1) throws SQLException {
				
				Student student = new Student();
				
				student.setId(rs.getInt("student.ID"));
				student.setName(rs.getString("student.name"));
				student.setEmail(rs.getString("student.email"));
				
				return student;
			}
	}
	
}

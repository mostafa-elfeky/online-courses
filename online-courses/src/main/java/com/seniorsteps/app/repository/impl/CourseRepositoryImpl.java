package com.seniorsteps.app.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.seniorsteps.app.filter.CourseFilter;
import com.seniorsteps.app.models.Category;
import com.seniorsteps.app.models.Content;
import com.seniorsteps.app.models.Course;
import com.seniorsteps.app.models.Field;
import com.seniorsteps.app.models.Instructor;
import com.seniorsteps.app.repository.CourseRepository;
import com.seniorsteps.app.service.LookupLoader;


@Repository
public class CourseRepositoryImpl implements CourseRepository {

	

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	private LookupLoader lookup;
	
	@Override
	public Course save(Course course) {
		
		String query = "INSERT INTO course (title, instructor_id, category_id) "
				+ "VALUES (:title, :instructor.id, :category.id)";
			
		KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(course);
		
		int insertedRows = jdbcTemplate.update(query, namedParameters, generatedKeyHolder);
		
		if (insertedRows > 0) {
			course.setId(generatedKeyHolder.getKey().intValue());
		}

		return course;
	}
	
	@Override
	public Course findById(int courseId) {
		
		Course course =  null;
		Map<String, Object> mapParameters = null;
		String query = " SELECT course.*, instructor.*, content.* FROM course "
				+ " JOIN instructor on (course.instructor_id = instructor.id) "
				+ " LEFT JOIN content on(content.course_id = course.id)"
				+ " WHERE course.id = :courseId ";
		
		mapParameters = new HashMap<String, Object>();
		mapParameters.put("courseId", courseId);

		course =  jdbcTemplate.query(query, mapParameters, new CourseDetailMapper());
		
		return course;
	}
	
	@Override
	public List<Course> list(CourseFilter filter) {
		
		List<Course> courses =  null;
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(filter);
		
		StringBuilder query = new StringBuilder(" SELECT course.*, instructor.* FROM course ");
		query.append(" JOIN instructor on (course.instructor_id = instructor.id) ");
		query.append(" WHERE 1=1 ");
		
		if(filter.getKeyword() != null) {
			query.append(" AND course.title LIKE :keyword");
		}
		
		query.append(" LIMIT :start, :count");

		courses =  jdbcTemplate.query(query.toString(), namedParameters, new CourseRowMapper());
		
		return courses;
	}

	@Override
	public boolean delete(int courseId) {
		
		Map<String, Object> mapParameters = new HashMap<String, Object>();
		mapParameters.put("id", courseId);

		String query = "DELETE FROM course WHERE course.id= :id";
			
		int deletedRows = jdbcTemplate.update(query, mapParameters);
		
		return deletedRows > 0;
	}

	@Override
	public boolean update(Course course) {

		String query = "UPDATE course SET title= :title, instructor_id= :instructor.id, "
				+ " category_id= :category.id"
				+ " WHERE course.id= :id";
			
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(course);
		
		int updatedRows = jdbcTemplate.update(query, namedParameters);
		
		return updatedRows > 0;
	}
	
	class CourseDetailMapper implements ResultSetExtractor<Course> {

		Course course = null;
		
		@Override
		public Course extractData(ResultSet rs) throws SQLException, DataAccessException {
			
			while(rs.next()) {
				
				if(course == null) {
					course = new Course();
					course.setId(rs.getInt("course.id"));
					course.setTitle(rs.getString("course.title"));
					course.setCategory(lookup.getCategoryPerId().get(rs.getInt("course.category_id")));
					
					Instructor instructor = new Instructor();
					instructor.setId(rs.getInt("instructor.id"));
					instructor.setName(rs.getString("instructor.name"));
					instructor.setEmail(rs.getString("instructor.email"));
					instructor.setYoutubeChannel(rs.getString("instructor.youtube_channel"));
					instructor.setLinkedIn(rs.getString("instructor.linedin"));
					instructor.setAbout(rs.getString("instructor.about"));
					instructor.setField(new Field(rs.getInt("instructor.field")));
					
					course.setInstructor(instructor);
				}
				
				Content content = new Content();
				content.setId(rs.getInt("content.id"));
				content.setDescription(rs.getString("content.description"));
				content.setPeriod(rs.getObject("content.period", LocalTime.class));
				content.setTitle(rs.getString("content.title"));
				content.setVideoId(rs.getString("content.video_id"));
				
				course.addContent(content);
			}
			
			return course;
		}
		
	}
	
	class CourseRowMapper implements RowMapper<Course> {
		
		@Override
		public Course mapRow(ResultSet rs, int arg1) throws SQLException {
			
			Course course = new Course();
			
			course.setId(rs.getInt("course.ID"));
			course.setId(rs.getInt("course.id"));
			course.setTitle(rs.getString("course.title"));
			course.setCategory(new Category(rs.getInt("course.category_id")));
			
			Instructor instructor = new Instructor();
			instructor.setId(rs.getInt("instructor.id"));
			instructor.setName(rs.getString("instructor.name"));
			instructor.setEmail(rs.getString("instructor.email"));
			instructor.setYoutubeChannel(rs.getString("instructor.youtube_channel"));
			instructor.setLinkedIn(rs.getString("instructor.linedin"));
			instructor.setAbout(rs.getString("instructor.about"));
			instructor.setField(new Field(rs.getInt("instructor.field")));
			
			course.setInstructor(instructor);
			
			return course;
		}
	}


}

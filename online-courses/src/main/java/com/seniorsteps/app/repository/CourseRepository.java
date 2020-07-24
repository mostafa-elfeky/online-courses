package com.seniorsteps.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seniorsteps.app.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>  {

	@Override
	@EntityGraph("Course.Details")
	Optional<Course> findById(Integer id); 
	
}
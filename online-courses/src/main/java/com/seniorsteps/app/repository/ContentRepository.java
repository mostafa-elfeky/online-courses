package com.seniorsteps.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.seniorsteps.app.models.Content;

@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {

	@Modifying
	void deleteByCourseId(int courseId);

}
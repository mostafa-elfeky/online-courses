package com.seniorsteps.app.repository;

import java.util.List;

import com.seniorsteps.app.filter.SearchFilter;
import com.seniorsteps.app.models.Content;

public interface ContentRepository {

	Content save(Content content);

	boolean delete(int contentId);
	
	boolean deleteByCourseId(int courseId);

	boolean update(Content content);
	
	Content findById(int contentId);

	List<Content> list(SearchFilter filter);

}
package com.seniorsteps.app.repository;

import java.util.List;

import com.seniorsteps.app.models.Category;
import com.seniorsteps.app.models.Gender;

public interface GeneralRepository {


	List<Category> listCategories();
	List<Gender> listGeneders();
	
}
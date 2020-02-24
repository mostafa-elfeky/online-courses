package com.seniorsteps.app.repository;

import java.util.List;

import com.seniorsteps.app.models.Category;
import com.seniorsteps.app.models.Gender;
import com.seniorsteps.app.models.UserType;

public interface GeneralRepository {

	List<Category> listCategories();
	List<Gender> listGeneders();
	List<UserType> listUserTypes();
	
}
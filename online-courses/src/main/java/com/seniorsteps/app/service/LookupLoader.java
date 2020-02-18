package com.seniorsteps.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seniorsteps.app.models.Category;
import com.seniorsteps.app.models.Gender;
import com.seniorsteps.app.repository.GeneralRepository;


@Component
public class LookupLoader {

	@Autowired
	GeneralRepository generalRepository;


	private Map<Integer, Category> categoryPerId;
	private Map<String, Category> categoryPerCode;

	private Map<Integer, Gender> genderPerId;
	private Map<String, Gender> genderPerCode;

	@PostConstruct
	public void loadCategories() throws Exception {

		try {

			List<Category> categories = generalRepository.listCategories();
			
			System.out.println(categories);
			
			categoryPerId = new HashMap<Integer, Category>();
			categoryPerCode = new HashMap<String, Category>();

			for (Category category : categories) {
				categoryPerId.put(category.getId(), category);
				categoryPerCode.put(category.getCode(), category);
			}

		} catch (Exception exp) {
			exp.printStackTrace();
			System.out.println("error on load categories.");
		}
	}

	@PostConstruct
	public void loadGeneders() throws Exception {

		try {

			List<Gender> genders = generalRepository.listGeneders();
			
			genderPerId = new HashMap<Integer, Gender>();
			genderPerCode = new HashMap<String, Gender>();

			for (Gender gender : genders) {
				genderPerId.put(gender.getId(), gender);
				genderPerCode.put(gender.getCode(), gender);
			}

		} catch (Exception exp) {
			exp.printStackTrace();
			System.out.println("error on load genders.");
		}
	}

	public Map<Integer, Category> getCategoryPerId() {
		return categoryPerId;
	}

	public Map<String, Category> getCategoryPerCode() {
		return categoryPerCode;
	}

	public Map<Integer, Gender> getGenderPerId() {
		return genderPerId;
	}

	public Map<String, Gender> getGenderPerCode() {
		return genderPerCode;
	}

	
	
}


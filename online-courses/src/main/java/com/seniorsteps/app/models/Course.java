package com.seniorsteps.app.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Course {

	private int id;
	private String title;
	private Instructor instructor;
	private Category category;
	private Set<Enrollment> enrollments;
	private List<Content> contents;
	
	public Course() {}
	
	public Course(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(Set<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public List<Content> getContents() {
		return contents;
	}

	public void setContents(List<Content> contents) {
		this.contents = contents;
	}

	public void addContent(Content content) {
		if(contents == null) {
			contents = new ArrayList<Content>();
		}
		
		contents.add(content);
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", instructor=" + instructor + ", category=" + category
				+ ", enrollments=" + enrollments + ", contents=" + contents + "]";
	}
	
	
}

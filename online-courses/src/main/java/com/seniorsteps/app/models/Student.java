package com.seniorsteps.app.models;

import java.util.Set;

public class Student {

	private int id;
	private String name;
	private String email;
	private int experienceLevel;
	
	private Set<Course> courses;
	private User user;
	
	public Student() {}
	
	public Student(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getExperienceLevel() {
		return experienceLevel;
	}
	public void setExperienceLevel(int experienceLevel) {
		this.experienceLevel = experienceLevel;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", experienceLevel=" + experienceLevel
				+ ", courses=" + courses + ", user=" + user + "]";
	}
	
}

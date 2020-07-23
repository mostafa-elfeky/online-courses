package com.seniorsteps.app.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="EXPERIENCE_LEVEL")
	private int experienceLevel;
	
	@Column(name="ID")
	@ManyToMany
	@JoinTable(
			joinColumns=@JoinColumn(name="STUDENT_ID"), 
			inverseJoinColumns=@JoinColumn(name="COURSE_ID"))
	private Set<Course> courses;
	
	@OneToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	public Student() {}
	
	public Student(Integer id) {
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
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}

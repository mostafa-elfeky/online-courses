package com.seniorsteps.app.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="COURSE")
public class Course {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="IMAGE")
	private String image;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="INSTRUCTOR_ID")
	private Instructor instructor;
	
	@ManyToOne
	@JoinColumn(name="CATEGORY_ID")
	private Lookup category;
	
	@OneToMany(mappedBy="course")
	private Set<Enrollment> enrollments;
	
	@OneToMany(mappedBy="course")
	private List<Content> contents;
	
	@OneToOne(mappedBy="course")
	private CourseStatistics statistics;
	
	public Course() {}
	
	public Course(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Lookup getCategory() {
		return category;
	}

	public void setCategory(Lookup category) {
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CourseStatistics getStatistics() {
		return statistics;
	}

	public void setStatistics(CourseStatistics statistics) {
		this.statistics = statistics;
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

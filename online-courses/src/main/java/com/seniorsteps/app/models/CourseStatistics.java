package com.seniorsteps.app.models;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="COURSE_STATISTICS")
public class CourseStatistics {

	@Id
	private Integer id;

	@OneToOne
	@JoinColumn(name="COURSE_ID")
	private Course course;
	
	@Column(name="ENROLLMENTCOUNT")
	private int enrollmentCount;
	
	@Column(name="REVIEW_COUNT")
	private int reviewCount;
	
	@Column(name="REVIEW_RATE")
	private double reviewRate;
	
	@Column(name="CONTENT_COUNT")
	private int contentCount;
	
	@Column(name="CONTENT_TOTAL_TIME")
	private LocalTime contentTotalTime;
	
	
	public CourseStatistics() {}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getEnrollmentCount() {
		return enrollmentCount;
	}

	public void setEnrollmentCount(int enrollmentCount) {
		this.enrollmentCount = enrollmentCount;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public double getReviewRate() {
		return reviewRate;
	}

	public void setReviewRate(double reviewRate) {
		this.reviewRate = reviewRate;
	}

	public int getContentCount() {
		return contentCount;
	}

	public void setContentCount(int contentCount) {
		this.contentCount = contentCount;
	}

	public LocalTime getContentTotalTime() {
		return contentTotalTime;
	}

	public void setContentTotalTime(LocalTime contentTotalTime) {
		this.contentTotalTime = contentTotalTime;
	}
	
}

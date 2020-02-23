package com.seniorsteps.app.models;

import java.time.LocalTime;

public class CourseStatistics {

	private int courseId;
	private int enrollmentCount;
	
	private int reviewCount;
	private double reviewRate;
	
	private int contentCount;
	private LocalTime contentTotalTime;
	
	
	public CourseStatistics() {}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
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

	@Override
	public String toString() {
		return "CourseStatistics [courseId=" + courseId + ", enrollmentCount=" + enrollmentCount + ", reviewCount="
				+ reviewCount + ", reviewRate=" + reviewRate + ", contentCount=" + contentCount + ", contentTotalTime="
				+ contentTotalTime + "]";
	}
	
	
	
	
	
}

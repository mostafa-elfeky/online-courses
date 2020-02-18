package com.seniorsteps.app.models;

import java.time.LocalTime;

public class Content {

	private int id;
	private String title;
	private String videoId;
	private LocalTime period;
	private String description;
	
	private Course course;

	public Content() {}
	
	public Content(int id) {
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

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public LocalTime getPeriod() {
		return period;
	}

	public void setPeriod(LocalTime period) {
		this.period = period;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Content [id=" + id + ", title=" + title + ", videoId=" + videoId + ", period=" + period
				+ ", description=" + description + ", course=" + course + "]";
	}
	
	
	
}

package com.seniorsteps.app.models;

import java.time.LocalDateTime;

public class Enrollment {

	private int id;
	private LocalDateTime enrolDate;
	private Course course;
	private Student student;
	
	public Enrollment() {}
	
	public Enrollment(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public LocalDateTime getEnrolDate() {
		return enrolDate;
	}
	public void setEnrolDate(LocalDateTime enrolDate) {
		this.enrolDate = enrolDate;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Enrollment [id=" + id + ", enrolDate=" + enrolDate + ", course=" + course + ", student="
				+ student + "]";
	}
	
}

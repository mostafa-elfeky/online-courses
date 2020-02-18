package com.seniorsteps.app.models;


public class Review {

	private int id;
	private short rate;
	private String comment;
	private Course course;
	private Student student;
	
	public Review() {}
	
	public Review(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public short getRate() {
		return rate;
	}
	public void setRate(short rate) {
		this.rate = rate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
		return "Review [id=" + id + ", rate=" + rate + ", comment=" + comment + ", course=" + course + ", student="
				+ student + "]";
	}
	
	
}

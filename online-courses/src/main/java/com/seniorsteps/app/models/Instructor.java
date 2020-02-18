package com.seniorsteps.app.models;



public class Instructor  {

	private int id;
	private String name;
	private String email;
	private String about;
	private String youtubeChannel;
	private String linkedIn;
	
	private Field field;
	private User user;
	
	public Instructor() {}
	
	public Instructor(int id) {
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

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getLinkedIn() {
		return linkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
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
		return "Instructor [id=" + id + ", name=" + name + ", email=" + email + ", about=" + about + ", youtubeChannel="
				+ youtubeChannel + ", linkedIn=" + linkedIn + ", field=" + field + ", user=" + user + "]";
	}
		
}

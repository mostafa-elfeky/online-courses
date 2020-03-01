package com.seniorsteps.app.models;

import java.io.Serializable;

public class UserType implements Serializable {

	
	
	private static final long serialVersionUID = 8206854630573066519L;

	private int id;
	private String name;
	private String code;
	
	public UserType() {}
	
	public UserType(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", code=" + code + "]";
	}
	
}

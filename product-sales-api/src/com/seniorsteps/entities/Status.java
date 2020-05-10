package com.seniorsteps.entities;

public class Status {

	private int statusId;
	private String name;
	
	public Status() {}
	
	public Status(int statusId) {
		super();
		this.statusId = statusId;
	}
	
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "ProductStatus [statusId=" + statusId + ", name=" + name + "]";
	}
	
	
}

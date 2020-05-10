package com.seniorsteps.queries;

import java.util.Date;

import javax.ws.rs.QueryParam;

public class ProductQuery {

	private @QueryParam("keyword") String keyword;
	private @QueryParam("birthdate") Date birthdate;
	private @QueryParam("isLoyal") boolean isLoyal;
	private @QueryParam("count") int count;
	private @QueryParam("start") int start;
	
	public String getKeyword() {
		return keyword != null ? "%" +keyword + "%" : null;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public boolean isLoyal() {
		return isLoyal;
	}
	public void setLoyal(boolean isLoyal) {
		this.isLoyal = isLoyal;
	}
	@Override
	public String toString() {
		return "CustomerQuery [keyword=" + keyword + ", birthdate=" + birthdate + ", isLoyal=" + isLoyal + ", count="
				+ count + ", start=" + start + "]";
	}
	
}

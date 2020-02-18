package com.seniorsteps.app.filter;

public class SearchFilter {

	private String keyword;
	private int start;
	private int count;
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		
		if(keyword != null) {
			this.keyword = "%" + keyword + "%";
		}
		
		this.keyword = keyword;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "SearchFilter [keyword=" + keyword + ", start=" + start + ", count=" + count + "]";
	}
	
}

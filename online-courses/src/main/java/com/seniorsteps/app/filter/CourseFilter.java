package com.seniorsteps.app.filter;

public class CourseFilter extends SearchFilter {

	private short rating;
	private short durationFrom;
	private short durationTo;
	private int categoryId;
	private String listingType;
	
	public short getRating() {
		return rating;
	}
	public void setRating(short rating) {
		this.rating = rating;
	}
	public short getDurationFrom() {
		return durationFrom;
	}
	public void setDurationFrom(short durationFrom) {
		this.durationFrom = durationFrom;
	}
	public short getDurationTo() {
		return durationTo;
	}
	public void setDurationTo(short durationTo) {
		this.durationTo = durationTo;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getListingType() {
		return listingType;
	}
	public void setListingType(String listingType) {
		this.listingType = listingType;
	}
	@Override
	public String toString() {
		return "CourseFilter [rating=" + rating + ", durationFrom=" + durationFrom + ", durationTo=" + durationTo + "]";
	}
	
	
}

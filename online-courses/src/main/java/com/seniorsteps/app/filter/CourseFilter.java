package com.seniorsteps.app.filter;

public class CourseFilter extends SearchFilter {

	private short rating;
	private short durationFrom;
	private short durationTo;
	
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
	@Override
	public String toString() {
		return "CourseFilter [rating=" + rating + ", durationFrom=" + durationFrom + ", durationTo=" + durationTo + "]";
	}
	
	
}

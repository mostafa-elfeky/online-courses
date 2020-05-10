package com.seniorsteps.entities;

public class ProductDetails {

	private int detailsId;
	private String info;
	
	public int getDetailsId() {
		return detailsId;
	}
	public void setDetailsId(int detailsId) {
		this.detailsId = detailsId;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "ProductDetails [detailsId=" + detailsId + ", info=" + info + "]";
	}

}

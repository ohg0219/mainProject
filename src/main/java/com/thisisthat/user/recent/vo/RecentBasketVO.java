package com.thisisthat.user.recent.vo;

public class RecentBasketVO {

	private String userId;
	private int productNo;
	private int productPrice;
	private int sizeXS;
	private int sizeS;
	private int sizeM;
	private int sizeL;
	private int sizeXL;
	private int selectCount;
	private String selectSize;
	
	
	
	public String getSelectSize() {
		return selectSize;
	}
	public void setSelectSize(String selectSize) {
		this.selectSize = selectSize;
	}
	public int getSelectCount() {
		return selectCount;
	}
	public void setSelectCount(int selectCount) {
		this.selectCount = selectCount;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getSizeXS() {
		return sizeXS;
	}
	public void setSizeXS(int sizeXS) {
		this.sizeXS = sizeXS;
	}
	public int getSizeS() {
		return sizeS;
	}
	public void setSizeS(int sizeS) {
		this.sizeS = sizeS;
	}
	public int getSizeM() {
		return sizeM;
	}
	public void setSizeM(int sizeM) {
		this.sizeM = sizeM;
	}
	public int getSizeL() {
		return sizeL;
	}
	public void setSizeL(int sizeL) {
		this.sizeL = sizeL;
	}
	public int getSizeXL() {
		return sizeXL;
	}
	public void setSizeXL(int sizeXL) {
		this.sizeXL = sizeXL;
	}
	
	@Override
	public String toString() {
		return "RecentBasketVO [userId=" + userId + ", productNo=" + productNo + ", productPrice=" + productPrice
				+ ", sizeXS=" + sizeXS + ", sizeS=" + sizeS + ", sizeM=" + sizeM + ", sizeL=" + sizeL + ", sizeXL="
				+ sizeXL + "]";
	}
}

package com.thisisthat.user.basket.vo;

public class UserBasketItemVO {

	private String userId;
	private long productNo;
	private String selectSize;
	private int selectCount;
	private long productPrice;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public long getProductNo() {
		return productNo;
	}
	public void setProductNo(long productNo) {
		this.productNo = productNo;
	}
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
	
	public long getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "UserBasketItemVO [userId=" + userId + ", productNo=" + productNo + ", selectSize=" + selectSize
				+ ", selectCount=" + selectCount + ", productPrice=" + productPrice + "]";
	}
	
	
	
}

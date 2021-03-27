package com.thisisthat.user.payment.vo;

public class UserBasketVO {

	private String userId;
	private int productNo;
	private String selectSize;
	private int productPrice;
	private int selectCount;
	
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

	public String getSelectSize() {
		return selectSize;
	}

	public void setSelectSize(String selectSize) {
		this.selectSize = selectSize;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getSelectCount() {
		return selectCount;
	}

	public void setSelectCount(int selectCount) {
		this.selectCount = selectCount;
	}

	@Override
	public String toString() {
		return "UserBasketVO [userId=" + userId + ", productNo=" + productNo + ", selectSize=" + selectSize
				+ ", productPrice=" + productPrice + ", selectCount=" + selectCount + "]";
	}
	
	
}

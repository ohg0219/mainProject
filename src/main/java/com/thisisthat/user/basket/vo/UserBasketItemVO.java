package com.thisisthat.user.basket.vo;

public class UserBasketItemVO {

	private String userId;
	private long productNo;
	private long productPrice;
	private String productName;
	private String selectSize;
	private int selectCount;
	private String uploadPath;
	private String productCategory;
	private String type;
	
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
	
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "UserBasketItemVO [userId=" + userId + ", productNo=" + productNo + ", productPrice=" + productPrice
				+ ", productName=" + productName + ", selectSize=" + selectSize + ", selectCount=" + selectCount
				+ ", uploadPath=" + uploadPath + ", productCategory=" + productCategory + ", type=" + type + "]";
	}
	
	
	
}

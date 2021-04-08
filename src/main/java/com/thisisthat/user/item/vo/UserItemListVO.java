package com.thisisthat.user.item.vo;

public class UserItemListVO {

	private String productCategory;
	private long productNo;
	private String uploadPath;
	private String productName;
	private String keyword;
	private long productPrice;
	private long productStockTotal;

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public long getProductNo() {
		return productNo;
	}

	public void setProductNo(long productNo) {
		this.productNo = productNo;
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String getProductName() {
		return productName;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}

	public long getProductStockTotal() {
		return productStockTotal;
	}

	public void setProductStockTotal(long productStockTotal) {
		this.productStockTotal = productStockTotal;
	}

	@Override
	public String toString() {
		return "UserItemListVO [productCategory=" + productCategory + ", productNo=" + productNo + ", uploadPath="
				+ uploadPath + ", productName=" + productName + ", keyword=" + keyword + ", productPrice="
				+ productPrice + ", productStockTotal=" + productStockTotal + "]";
	}

}

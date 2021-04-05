package com.thisisthat.user.recent.vo;

public class RecentViewVO {

	private String userId;
	private int select_count;
	private int productNo;
	private String mainImage;
	private String uploadPath;
	private String productName;
	private String productCategory;
	private int productPrice;
	private int sizeXS;
	private int sizeS;
	private int sizeM;
	private int sizeL;
	private int sizeXL;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getSelect_count() {
		return select_count;
	}
	public void setSelect_count(int select_count) {
		this.select_count = select_count;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getMainImage() {
		return mainImage;
	}
	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
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
	public void setProductName(String productName) {
		this.productName = productName;
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
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	
	@Override
	public String toString() {
		return "RecentViewVO [productNo=" + productNo + ", mainImage=" + mainImage + ", uploadPath=" + uploadPath
				+ ", productName=" + productName + ", sizeXS=" + sizeXS + ", sizeS=" + sizeS + ", sizeM=" + sizeM
				+ ", sizeL=" + sizeL + ", sizeXL=" + sizeXL + ", productPrice=" + productPrice + "]";
	}	
}
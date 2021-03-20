package com.thisisthat.user.item.vo;

public class UserItemImageVO {

	private long productNo;
	private String uploadPath;
	private String imageName;
	private int mainImage;
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
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public int getMainImage() {
		return mainImage;
	}
	public void setMainImage(int mainImage) {
		this.mainImage = mainImage;
	}
	@Override
	public String toString() {
		return "UserItemImageVO [productNo=" + productNo + ", uploadPath=" + uploadPath + ", imageName=" + imageName
				+ ", mainImage=" + mainImage + "]";
	}
	
	
	
	
}

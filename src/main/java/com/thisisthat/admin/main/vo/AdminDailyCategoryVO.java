package com.thisisthat.admin.main.vo;

public class AdminDailyCategoryVO {

	private String productCategory;
	private long count;
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "AdminDailyCategoryVO [productCategory=" + productCategory + ", count=" + count + "]";
	}
	
}

package com.thisisthat.admin.category.vo;

public class AdminCategoryVO {

	private int categorySeq;
	private String categoryName;
	private int categoryProduct;
	private int categoryUsed;

	public int getCategorySeq() {
		return categorySeq;
	}

	public void setCategorySeq(int categorySeq) {
		this.categorySeq = categorySeq;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getCategoryProduct() {
		return categoryProduct;
	}

	public void setCategoryProduct(int categoryProduct) {
		this.categoryProduct = categoryProduct;
	}

	public int getCategoryUsed() {
		return categoryUsed;
	}

	public void setCategoryUsed(int categoryUsed) {
		this.categoryUsed = categoryUsed;
	}

	@Override
	public String toString() {
		return "AdminCategoryVO [categorySeq=" + categorySeq + ", categoryName=" + categoryName + ", categoryProduct="
				+ categoryProduct + ", categoryUsed=" + categoryUsed + "]";
	}

}

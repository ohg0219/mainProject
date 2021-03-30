package com.thisisthat.user.payment.vo;

public class UserMailVO {

	private int orderNo;
	private int productNo;
	private String productName;
	private String orderSize;
	private int productPrice;
	private int selectCount;
	private int productTotal;
	
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getOrderSize() {
		return orderSize;
	}
	public void setOrderSize(String orderSize) {
		this.orderSize = orderSize;
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
	public int getProductTotal() {
		return productTotal;
	}
	public void setProductTotal(int productTotal) {
		this.productTotal = productTotal;
	}
	@Override
	public String toString() {
		return "UserMailVO [orderNo=" + orderNo + ", productNo=" + productNo + ", productName=" + productName
				+ ", orderSize=" + orderSize + ", productPrice=" + productPrice + ", selectCount=" + selectCount
				+ ", productTotal=" + productTotal + "]";
	}
	
	
}

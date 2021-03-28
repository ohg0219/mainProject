package com.thisisthat.user.payment.vo;

public class UserOrderVO {

	private int orderNo;
	private int productNo;
	private String selectSize;
	private int productPrice;
	private int selectCount;
	
	public UserOrderVO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public UserOrderVO(int orderNo, int productNo, String selectSize, int productPrice, int selectCount) {
		super();
		this.orderNo = orderNo;
		this.productNo = productNo;
		this.selectSize = selectSize;
		this.productPrice = productPrice;
		this.selectCount = selectCount;
	}


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
		return "UserOrderVO [orderNo=" + orderNo + ", productNo=" + productNo + ", selectSize=" + selectSize
				+ ", productPrice=" + productPrice + ", selectCount=" + selectCount + "]";
	}
	
}

package com.thisisthat.user.payment.vo;

public class UserOrderVO {

	private int orderNo;
	private long productNo;
	private String selectSize;
	private long productPrice;
	private int selectCount;

	public UserOrderVO() {
		// TODO Auto-generated constructor stub
	}

	public UserOrderVO(int orderNo, long productNo, String selectSize, long productPrice, int selectCount) {
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

	public long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(long productPrice) {
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

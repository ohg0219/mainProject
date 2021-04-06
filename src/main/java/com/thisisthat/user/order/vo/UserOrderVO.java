package com.thisisthat.user.order.vo;

import java.util.Date;

public class UserOrderVO {

	private String userId;
	private String receiveName;
	private String orderPassword;
	private Date orderDate;
	private int orderNo;
	private String productName;
	private int productPrice;
	private String orderSize;
	private int selectCount;
	private long originalPrice;
	private int usePoint;
	private int useCoupon;
	private long orderPrice;
	private String orderState;
	private long invoiceNo;
	private int count;
	private Date sDate;
	private Date eDate;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public String getOrderPassword() {
		return orderPassword;
	}

	public void setOrderPassword(String orderPassword) {
		this.orderPassword = orderPassword;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getOrderSize() {
		return orderSize;
	}

	public void setOrderSize(String orderSize) {
		this.orderSize = orderSize;
	}

	public int getSelectCount() {
		return selectCount;
	}

	public void setSelectCount(int selectCount) {
		this.selectCount = selectCount;
	}

	public long getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(long originalPrice) {
		this.originalPrice = originalPrice;
	}

	public int getUsePoint() {
		return usePoint;
	}

	public void setUsePoint(int usePoint) {
		this.usePoint = usePoint;
	}

	public int getUseCoupon() {
		return useCoupon;
	}

	public void setUseCoupon(int useCoupon) {
		this.useCoupon = useCoupon;
	}

	public long getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(long orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public long getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(long invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getsDate() {
		return sDate;
	}

	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}

	public Date geteDate() {
		return eDate;
	}

	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}

	@Override
	public String toString() {
		return "UserOrderVO [userId=" + userId + ", receiveName=" + receiveName + ", orderPassword=" + orderPassword
				+ ", orderDate=" + orderDate + ", orderNo=" + orderNo + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", orderSize=" + orderSize + ", selectCount=" + selectCount
				+ ", originalPrice=" + originalPrice + ", usePoint=" + usePoint + ", useCoupon=" + useCoupon
				+ ", orderPrice=" + orderPrice + ", orderState=" + orderState + ", invoiceNo=" + invoiceNo + ", count="
				+ count + ", sDate=" + sDate + ", eDate=" + eDate + "]";
	}

}

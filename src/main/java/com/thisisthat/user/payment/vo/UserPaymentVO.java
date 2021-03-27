package com.thisisthat.user.payment.vo;

import java.util.Date;

public class UserPaymentVO {

	private int order_no;
	private Date orderDate;
	private String userId;
	private String orderPassword;
	private String orderEmail;
	private String receiveName;
	private String receivePhone;
	private int receiveZipcode;
	private String receiveFirstAddress;
	private String receiveLastAddress;
	private String orderMessage;
	private int originalPrice;
	private int usePoint;
	private int useCoupon;
	private int orderPrice;
	private String orderSelect;
	private String passbookName;
	private String orderState;
	private int orderCancel;
	private int invoiceNo;
	private int waitingPoint;

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrderPassword() {
		return orderPassword;
	}

	public void setOrderPassword(String orderPassword) {
		this.orderPassword = orderPassword;
	}

	public String getOrderEmail() {
		return orderEmail;
	}

	public void setOrderEmail(String orderEmail) {
		this.orderEmail = orderEmail;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public String getReceivePhone() {
		return receivePhone;
	}

	public void setReceivePhone(String receivePhone) {
		this.receivePhone = receivePhone;
	}

	public int getReceiveZipcode() {
		return receiveZipcode;
	}

	public void setReceiveZipcode(int receiveZipcode) {
		this.receiveZipcode = receiveZipcode;
	}

	public String getReceiveFirstAddress() {
		return receiveFirstAddress;
	}

	public void setReceiveFirstAddress(String receiveFirstAddress) {
		this.receiveFirstAddress = receiveFirstAddress;
	}

	public String getReceiveLastAddress() {
		return receiveLastAddress;
	}

	public void setReceiveLastAddress(String receiveLastAddress) {
		this.receiveLastAddress = receiveLastAddress;
	}

	public String getOrderMessage() {
		return orderMessage;
	}

	public void setOrderMessage(String orderMessage) {
		this.orderMessage = orderMessage;
	}

	public int getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(int originalPrice) {
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

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getOrderSelect() {
		return orderSelect;
	}

	public void setOrderSelect(String orderSelect) {
		this.orderSelect = orderSelect;
	}

	public String getPassbookName() {
		return passbookName;
	}

	public void setPassbookName(String passbookName) {
		this.passbookName = passbookName;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public int getOrderCancel() {
		return orderCancel;
	}

	public void setOrderCancel(int orderCancel) {
		this.orderCancel = orderCancel;
	}

	public int getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public int getWaitingPoint() {
		return waitingPoint;
	}

	public void setWaitingPoint(int waitingPoint) {
		this.waitingPoint = waitingPoint;
	}

	@Override
	public String toString() {
		return "UserPaymentVO [order_no=" + order_no + ", orderDate=" + orderDate + ", userId=" + userId
				+ ", orderPassword=" + orderPassword + ", orderEmail=" + orderEmail + ", receiveName=" + receiveName
				+ ", receivePhone=" + receivePhone + ", receiveZipcode=" + receiveZipcode + ", receiveFirstAddress="
				+ receiveFirstAddress + ", receiveLastAddress=" + receiveLastAddress + ", orderMessage=" + orderMessage
				+ ", originalPrice=" + originalPrice + ", usePoint=" + usePoint + ", useCoupon=" + useCoupon
				+ ", orderPrice=" + orderPrice + ", orderSelect=" + orderSelect + ", passbookName=" + passbookName
				+ ", orderState=" + orderState + ", orderCancel=" + orderCancel + ", invoiceNo=" + invoiceNo
				+ ", waitingPoint=" + waitingPoint + "]";
	}

}

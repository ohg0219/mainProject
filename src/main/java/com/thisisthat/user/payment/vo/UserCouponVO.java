package com.thisisthat.user.payment.vo;

import java.util.Date;

public class UserCouponVO {

	private String userId;
	private long couponNo;
	private String couponName;
	private long couponPrice;
	private Date couponDate;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public long getCouponNo() {
		return couponNo;
	}
	public void setCouponNo(long couponNo) {
		this.couponNo = couponNo;
	}
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public long getCouponPrice() {
		return couponPrice;
	}
	public void setCouponPrice(long couponPrice) {
		this.couponPrice = couponPrice;
	}
	public Date getCouponDate() {
		return couponDate;
	}
	public void setCouponDate(Date couponDate) {
		this.couponDate = couponDate;
	}
	@Override
	public String toString() {
		return "UserCouponVO [userId=" + userId + ", couponNo=" + couponNo + ", couponName=" + couponName
				+ ", couponPrice=" + couponPrice + ", couponDate=" + couponDate + "]";
	}
	
}

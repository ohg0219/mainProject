package com.thisisthat.user.coupon.vo;

import java.util.Date;

public class UserCouponVO {

	private String couponName;
	private long couponPrice;
	private Date couponLast;

	

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

	public Date getCouponLast() {
		return couponLast;
	}

	public void setCouponLast(Date couponLast) {
		this.couponLast = couponLast;
	}

	@Override
	public String toString() {
		return "UserCouponVO [couponName=" + couponName + ", couponPrice=" + couponPrice + ", couponLast=" + couponLast
				+ "]";
	}

	
	
}

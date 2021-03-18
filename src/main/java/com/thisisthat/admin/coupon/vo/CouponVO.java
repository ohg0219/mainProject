package com.thisisthat.admin.coupon.vo;

import java.sql.Date;

public class CouponVO {
	
	private int coupon_no;
	private String coupon_name;
	private int coupon_price;
	private Date coupon_first;
	private Date coupon_last;
	public int getCoupon_no() {
		return coupon_no;
	}
	public void setCoupon_no(int coupon_no) {
		this.coupon_no = coupon_no;
	}
	public String getCoupon_name() {
		return coupon_name;
	}
	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}
	public int getCoupon_price() {
		return coupon_price;
	}
	public void setCoupon_price(int coupon_price) {
		this.coupon_price = coupon_price;
	}
	public Date getCoupon_first() {
		return coupon_first;
	}
	public void setCoupon_first(Date coupon_first) {
		this.coupon_first = coupon_first;
	}
	public Date getCoupon_last() {
		return coupon_last;
	}
	public void setCoupon_last(Date coupon_last) {
		this.coupon_last = coupon_last;
	}
	@Override
	public String toString() {
		return "CouponVO [coupon_no=" + coupon_no + ", coupon_name=" + coupon_name + ", coupon_price=" + coupon_price
				+ ", coupon_first=" + coupon_first + ", coupon_last=" + coupon_last + "]";
	}
	
	
	
	
	
}//end class

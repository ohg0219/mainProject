package com.thisisthat.admin.coupon.vo;

import java.util.Date;

public class CouponVO {
	
	private Long coupon_no;
	private String coupon_name;
	private Long coupon_price;
	private Date coupon_first;
	private Date coupon_last;
	private String keyword;
	
	public Long getCoupon_price() {
		return coupon_price;
	}
	public void setCoupon_price(Long coupon_price) {
		this.coupon_price = coupon_price;
	}
	
	public Long getCoupon_no() {
		return coupon_no;
	}
	public void setCoupon_no(Long coupon_no) {
		this.coupon_no = coupon_no;
	}
	public String getCoupon_name() {
		return coupon_name;
	}
	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
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
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "CouponVO [coupon_no=" + coupon_no + ", coupon_name=" + coupon_name + ", coupon_price=" + coupon_price
				+ ", coupon_first=" + coupon_first + ", coupon_last=" + coupon_last + ", keyword=" + keyword + "]";
	}
	
	
	
	
	
	
	
	
}//end class

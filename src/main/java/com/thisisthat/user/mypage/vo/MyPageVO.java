package com.thisisthat.user.mypage.vo;

public class MyPageVO {

	private String userName;
	private String userId;
	private String nickName;
	private int orderPrice;
	private int point;
	private int used;
	private String couponLast;
	private int orderCount;
	private int countCoupon;
	private int totalPrice;
	private int totalPoint;
	
	
	
	public int getTotalPoint() {
		return totalPoint;
	}
	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public int getCountCoupon() {
		return countCoupon;
	}
	public void setCountCoupon(int countCoupon) {
		this.countCoupon = countCoupon;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getUsed() {
		return used;
	}
	public void setUsed(int used) {
		this.used = used;
	}
	public String getCouponLast() {
		return couponLast;
	}
	public void setCouponLast(String couponLast) {
		this.couponLast = couponLast;
	}
	
	@Override
	public String toString() {
		return "MyPageVO [userId=" + userId + ", nickName=" + nickName + ", orderPrice=" + orderPrice + ", point="
				+ point + ", used=" + used + ", couponLast=" + couponLast + "]";
	}	
}

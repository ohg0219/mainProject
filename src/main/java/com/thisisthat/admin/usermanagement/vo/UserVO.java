package com.thisisthat.admin.usermanagement.vo;

import java.util.Date;

public class UserVO {

	private String userId;
	private String userName;
	private String nickName;
	private String userPhone;
	private String userEmail;
	private String firstAddress;
	private String lastAddress;
	private int userRole;
	private Date inDate;
	private Date outDate;
	private String userImg;
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getFirstAddress() {
		return firstAddress;
	}
	public void setFirstAddress(String firstAddress) {
		this.firstAddress = firstAddress;
	}
	public String getLastAddress() {
		return lastAddress;
	}
	public void setLastAddress(String lastAddress) {
		this.lastAddress = lastAddress;
	}
	public int getUserRole() {
		return userRole;
	}
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
	public Date getInDate() {
		return inDate;
	}
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	public Date getOutDate() {
		return outDate;
	}
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	
}
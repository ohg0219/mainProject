package com.thisisthat.user.register.vo;

import java.util.Date;

public class UserRegisterVO {
	private String id; 
	private String password; 
	private String nickName;
	private String name; 
	private String phone; 
	private String email; 
	private String zipcode; 
	private String address1; 
	private String address2; 
	private int user_role; 
	private Date inDate;
	private Date outDate;
	private int smsOk;
	private int emailOk;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public int getUser_role() {
		return user_role;
	}
	public void setUser_role(int user_role) {
		this.user_role = user_role;
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
	public int getSmsOk() {
		return smsOk;
	}
	public void setSmsOk(int smsOk) {
		this.smsOk = smsOk;
	}
	public int getEmailOk() {
		return emailOk;
	}
	public void setEmailOk(int emailOk) {
		this.emailOk = emailOk;
	}
	@Override
	public String toString() {
		return "UserRegisterVO [id=" + id + ", password=" + password + ", nickName=" + nickName + ", name=" + name
				+ ", phone=" + phone + ", email=" + email + ", zipcode=" + zipcode + ", address1=" + address1
				+ ", address2=" + address2 + ", user_role=" + user_role + ", inDate=" + inDate + ", outDate=" + outDate
				+ ", smsOk=" + smsOk + ", emailOk=" + emailOk + "]";
	}
	
}

package com.thisisthat.user.register.vo;

import java.sql.Date;

public class UserRegisterVO {
	private String id; 
	private String password; 
	private String nickName;
	private String name; 
	private String phone; 
	private String email; 
	private int zipcode; 
	private String address1; 
	private String address2; 
	private int user_role; 
	private Date life;
	private Date life_date;
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
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
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
	public Date getLife() {
		return life;
	}
	public void setLife(Date life) {
		this.life = life;
	}
	public Date getLife_date() {
		return life_date;
	}
	public void setLife_date(Date life_date) {
		this.life_date = life_date;
	}
	
	
	
}

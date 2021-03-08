package com.thisisthat.user.register.vo;

import java.sql.Date;

public class UserRegisterVO {
	private String user_id; 
	private String user_pass; 
	private String nick_name;
	private String name; 
	private int phone; 
	private String email; 
	private int zipcode; 
	private String first_address; 
	private String last_address; 
	private int user_role; 
	private Date life;
	private Date life_date;
	
	
	
	public String getUser_id() {
		return user_id;
	}



	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}



	public String getUser_pass() {
		return user_pass;
	}



	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}



	public String getNick_name() {
		return nick_name;
	}



	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getPhone() {
		return phone;
	}



	public void setPhone(int phone) {
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



	public String getFirst_address() {
		return first_address;
	}



	public void setFirst_address(String first_address) {
		this.first_address = first_address;
	}



	public String getLast_address() {
		return last_address;
	}



	public void setLast_address(String last_address) {
		this.last_address = last_address;
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



	@Override
	public String toString() {
		return "UserRegisterVO [user_id=" + user_id + ", user_pass=" + user_pass + ", nick_name=" + nick_name
				+ ", name=" + name + ", phone=" + phone + ", email=" + email + ", zipcode=" + zipcode
				+ ", first_address=" + first_address + ", last_address=" + last_address + ", user_role=" + user_role
				+ ", life=" + life + ", life_date=" + life_date + "]";
	}
	
}

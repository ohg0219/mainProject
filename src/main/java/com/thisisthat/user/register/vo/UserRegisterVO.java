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
	@Override
	public String toString() {
		return "UserRegisterVO [user_id=" + user_id + ", user_pass=" + user_pass + ", nick_name=" + nick_name
				+ ", name=" + name + ", phone=" + phone + ", email=" + email + ", zipcode=" + zipcode
				+ ", first_address=" + first_address + ", last_address=" + last_address + ", user_role=" + user_role
				+ ", life=" + life + ", life_date=" + life_date + "]";
	}
	
}

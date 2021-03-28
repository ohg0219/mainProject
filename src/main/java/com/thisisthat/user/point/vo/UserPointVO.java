package com.thisisthat.user.point.vo;

import java.util.Date;

public class UserPointVO {
	
	private String user_id;
	private Date point_date;
	private int point;
	private String point_content;
	private int point_num;
	private int sum;
	private int usingsum;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getPoint_date() {
		return point_date;
	}
	public void setPoint_date(Date point_date) {
		this.point_date = point_date;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	public String getPoint_content() {
		return point_content;
	}
	public void setPoint_content(String point_content) {
		this.point_content = point_content;
	}
	public int getPoint_num() {
		return point_num;
	}
	public void setPoint_num(int point_num) {
		this.point_num = point_num;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getUsingsum() {
		return usingsum;
	}
	public void setUsingsum(int usingsum) {
		this.usingsum = usingsum;
	}
	@Override
	public String toString() {
		return "UserPointVO [user_id=" + user_id + ", point_date=" + point_date + ", point=" + point
				+ ", point_content=" + point_content + ", point_num=" + point_num + ", sum=" + sum + ", usingsum="
				+ usingsum + "]";
	}
	
	
	
	
	
}

package com.thisisthat.admin.terms.vo;

import java.util.Date;

public class UtilizationVO {
	private int no;
	private String content;
	private Date regDate = new Date();
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}

package com.thisisthat.admin.point.vo;

import java.util.Date;

public class PointVO {
	private String userId;
	private Date pointDate;
	private int point;
	private int pointNum;
	private String pointContent;
	
	@Override
	public String toString() {
		return "PointVO [userId=" + userId + ", pointDate=" + pointDate + ", point=" + point + ", pointNum=" + pointNum
				+ ", pointContent=" + pointContent + "]";
	}
	public int getPointNum() {
		return pointNum;
	}
	public void setPointNum(int pointNum) {
		this.pointNum = pointNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getPointDate() {
		return pointDate;
	}
	public void setPointDate(Date pointDate) {
		this.pointDate = pointDate;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getPointContent() {
		return pointContent;
	}
	public void setPointContent(String pointContent) {
		this.pointContent = pointContent;
	}
}

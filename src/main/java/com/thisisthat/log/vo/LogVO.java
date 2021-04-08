package com.thisisthat.log.vo;

import java.util.Date;

public class LogVO {
	private Long logNo;
	private String userId;
	private String adminId;
	private Long performanceTime;
	private Date performanceDate = new Date();
	private String performanceMethod;
	
	@Override
	public String toString() {
		return "LogVO [LogNo=" + logNo + ", userId=" + userId + ", adminId=" + adminId + ", performanceTime="
				+ performanceTime + ", performanceDate=" + performanceDate + ", performanceMethod=" + performanceMethod
				+ "]";
	}
	public Long getLogNo() {
		return logNo;
	}
	public void setLogNo(Long logNo) {
		this.logNo = logNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public Long getPerformanceTime() {
		return performanceTime;
	}
	public void setPerformanceTime(Long performanceTime) {
		this.performanceTime = performanceTime;
	}
	public Date getPerformanceDate() {
		return performanceDate;
	}
	public void setPerformanceDate(Date performanceDate) {
		this.performanceDate = performanceDate;
	}
	public String getPerformanceMethod() {
		return performanceMethod;
	}
	public void setPerformanceMethod(String performanceMethod) {
		this.performanceMethod = performanceMethod;
	}
	
}

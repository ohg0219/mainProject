package com.thisisthat.admin.sales.vo;

import java.util.Date;

public class AdminSalesDataVO {

	private Date grouping;
	private String groupString;
	private long subtotal;
	public Date getGrouping() {
		return grouping;
	}
	public void setGrouping(Date grouping) {
		this.grouping = grouping;
	}
	public String getGroupString() {
		return groupString;
	}
	public void setGroupString(String groupString) {
		this.groupString = groupString;
	}
	public long getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(long subtotal) {
		this.subtotal = subtotal;
	}
	@Override
	public String toString() {
		return "AdminSalesMonthVO [grouping=" + grouping + ", groupString=" + groupString + ", subtotal=" + subtotal
				+ "]";
	}
	
}

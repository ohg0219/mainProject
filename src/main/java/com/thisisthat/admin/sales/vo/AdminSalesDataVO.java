package com.thisisthat.admin.sales.vo;

import java.util.Date;

public class AdminSalesDataVO {

	private Date grouping;
	private String groupString;
	private long count;
	private long originalPrice;
	private long usePoint;
	private long useCoupon;
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

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public long getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(long originalPrice) {
		this.originalPrice = originalPrice;
	}

	public long getUsePoint() {
		return usePoint;
	}

	public void setUsePoint(long usePoint) {
		this.usePoint = usePoint;
	}

	public long getUseCoupon() {
		return useCoupon;
	}

	public void setUseCoupon(long useCoupon) {
		this.useCoupon = useCoupon;
	}

	public long getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(long subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		return "AdminSalesDataVO [grouping=" + grouping + ", groupString=" + groupString + ", count=" + count
				+ ", originalPrice=" + originalPrice + ", usePoint=" + usePoint + ", useCoupon=" + useCoupon
				+ ", subtotal=" + subtotal + "]";
	}

}

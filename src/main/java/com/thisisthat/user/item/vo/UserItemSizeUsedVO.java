package com.thisisthat.user.item.vo;

public class UserItemSizeUsedVO {

	private long product_no; 
	private int xs_used;
	private int s_used;
	private int m_used;
	private int l_used;
	private int xl_used;
	public long getProduct_no() {
		return product_no;
	}
	public void setProduct_no(long product_no) {
		this.product_no = product_no;
	}
	public int getXs_used() {
		return xs_used;
	}
	public void setXs_used(int xs_used) {
		this.xs_used = xs_used;
	}
	public int getS_used() {
		return s_used;
	}
	public void setS_used(int s_used) {
		this.s_used = s_used;
	}
	public int getM_used() {
		return m_used;
	}
	public void setM_used(int m_used) {
		this.m_used = m_used;
	}
	public int getL_used() {
		return l_used;
	}
	public void setL_used(int l_used) {
		this.l_used = l_used;
	}
	public int getXl_used() {
		return xl_used;
	}
	public void setXl_used(int xl_used) {
		this.xl_used = xl_used;
	}
	@Override
	public String toString() {
		return "UserItemSizeUsedVO [product_no=" + product_no + ", xs_used=" + xs_used + ", s_used=" + s_used
				+ ", m_used=" + m_used + ", l_used=" + l_used + ", xl_used=" + xl_used + "]";
	}
	
	
}

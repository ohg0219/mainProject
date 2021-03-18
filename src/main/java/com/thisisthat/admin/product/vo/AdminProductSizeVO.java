package com.thisisthat.admin.product.vo;

public class AdminProductSizeVO {
	private long product_no; 
	private String guideSelector;
	private double xs_size;
	private double s_size;
	private double m_size;
	private double l_size;
	private double xl_size;
	public long getProduct_no() {
		return product_no;
	}
	public void setProduct_no(long product_no) {
		this.product_no = product_no;
	}
	public double getXs_size() {
		return xs_size;
	}
	public void setXs_size(double xs_size) {
		this.xs_size = xs_size;
	}
	public double getS_size() {
		return s_size;
	}
	public void setS_size(double s_size) {
		this.s_size = s_size;
	}
	public double getM_size() {
		return m_size;
	}
	public void setM_size(double m_size) {
		this.m_size = m_size;
	}
	public double getL_size() {
		return l_size;
	}
	public void setL_size(double l_size) {
		this.l_size = l_size;
	}
	public double getXl_size() {
		return xl_size;
	}
	public void setXl_size(double xl_size) {
		this.xl_size = xl_size;
	}
	public String getGuideSelector() {
		return guideSelector;
	}
	public void setGuideSelector(String guideSelector) {
		this.guideSelector = guideSelector;
	}
	@Override
	public String toString() {
		return "AdminProductSizeVO [product_no=" + product_no + ", guideSelector=" + guideSelector + ", xs_size="
				+ xs_size + ", s_size=" + s_size + ", m_size=" + m_size + ", l_size=" + l_size + ", xl_size=" + xl_size
				+ "]";
	}
	
}

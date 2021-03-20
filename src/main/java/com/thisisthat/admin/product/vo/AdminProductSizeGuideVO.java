package com.thisisthat.admin.product.vo;

public class AdminProductSizeGuideVO {
	private long product_no; 
	private String guideSelector;
	private String size_item;
	private String xs_size;
	private String s_size;
	private String m_size;
	private String l_size;
	private String xl_size;
	public long getProduct_no() {
		return product_no;
	}
	public void setProduct_no(long product_no) {
		this.product_no = product_no;
	}
	public String getGuideSelector() {
		return guideSelector;
	}
	public void setGuideSelector(String guideSelector) {
		this.guideSelector = guideSelector;
	}
	
	public String getSize_item() {
		return size_item;
	}
	public void setSize_item(String size_item) {
		this.size_item = size_item;
	}
	public String getXs_size() {
		return xs_size;
	}
	public void setXs_size(String xs_size) {
		this.xs_size = xs_size;
	}
	public String getS_size() {
		return s_size;
	}
	public void setS_size(String s_size) {
		this.s_size = s_size;
	}
	public String getM_size() {
		return m_size;
	}
	public void setM_size(String m_size) {
		this.m_size = m_size;
	}
	public String getL_size() {
		return l_size;
	}
	public void setL_size(String l_size) {
		this.l_size = l_size;
	}
	public String getXl_size() {
		return xl_size;
	}
	public void setXl_size(String xl_size) {
		this.xl_size = xl_size;
	}
	@Override
	public String toString() {
		return "AdminProductSizeVO [product_no=" + product_no + ", guideSelector=" + guideSelector + ", size_item="
				+ size_item + ", xs_size=" + xs_size + ", s_size=" + s_size + ", m_size=" + m_size + ", l_size="
				+ l_size + ", xl_size=" + xl_size + "]";
	}
	
	
}

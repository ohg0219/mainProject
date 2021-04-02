package com.thisisthat.admin.productstock.vo;

public class ProductStockVO {

	// 상품 번호
	private int product_no; // 자료형 확인해야함

	// 상품 사이즈별 수량
	private int xs;
	private int s;
	private int m;
	private int l;
	private int xl;

	// 상품 사이즈별 사용 유무
	private int xs_used;
	private int s_used;
	private int m_used;
	private int l_used;
	private int xl_used;

	// 상품 카테고리
	private String product_category; // 자료형 확인해야함
	private String product_name;
	
	//키워드
	private String keyword;
	
	
	
	

	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public int getXs() {
		return xs;
	}

	public void setXs(int xs) {
		this.xs = xs;
	}

	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}

	public int getXl() {
		return xl;
	}

	public void setXl(int xl) {
		this.xl = xl;
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

	public String getProduct_category() {
		return product_category;
	}

	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}

	@Override
	public String toString() {
		return "ProductStockVO [product_no=" + product_no + ", xs=" + xs + ", s=" + s + ", m=" + m + ", l=" + l
				+ ", xl=" + xl + ", xs_used=" + xs_used + ", s_used=" + s_used + ", m_used=" + m_used + ", l_used="
				+ l_used + ", xl_used=" + xl_used + ", product_category=" + product_category + ", product_name="
				+ product_name + ", keyword=" + keyword + "]";
	}

	
}// end class

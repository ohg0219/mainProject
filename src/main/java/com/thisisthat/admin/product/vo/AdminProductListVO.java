package com.thisisthat.admin.product.vo;

public class AdminProductListVO {

	private long product_no;
	private String product_category;
	private String product_name;
	private String upload_path;
	private long product_price;
	private long product_stock_total;
	private int product_used;
	public long getProduct_no() {
		return product_no;
	}
	public void setProduct_no(long product_no) {
		this.product_no = product_no;
	}
	public String getProduct_category() {
		return product_category;
	}
	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getUpload_path() {
		return upload_path;
	}
	public void setUpload_path(String upload_path) {
		this.upload_path = upload_path;
	}
	public long getProduct_price() {
		return product_price;
	}
	public void setProduct_price(long product_price) {
		this.product_price = product_price;
	}
	public long getProduct_stock_total() {
		return product_stock_total;
	}
	public void setProduct_stock_total(long product_stock_total) {
		this.product_stock_total = product_stock_total;
	}
	
	public int getProduct_used() {
		return product_used;
	}
	public void setProduct_used(int product_used) {
		this.product_used = product_used;
	}
	@Override
	public String toString() {
		return "AdminProductListVO [product_no=" + product_no + ", product_category=" + product_category
				+ ", product_name=" + product_name + ", upload_path=" + upload_path + ", product_price=" + product_price
				+ ", product_stock_total=" + product_stock_total + ", product_used=" + product_used + "]";
	}
	
	
}

package com.thisisthat.admin.product.vo;

public class AdminProductVO {

	private long product_no;
	private String product_category;
	private String product_name;
	private long product_price;
	private String material_info;
	private String origin;
	private String product_info;
	private int product_point;
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
	public long getProduct_price() {
		return product_price;
	}
	public void setProduct_price(long product_price) {
		this.product_price = product_price;
	}
	public String getMaterial_info() {
		return material_info;
	}
	public void setMaterial_info(String material_info) {
		this.material_info = material_info;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getProduct_info() {
		return product_info;
	}
	public void setProduct_info(String product_info) {
		this.product_info = product_info;
	}
	public int getProduct_point() {
		return product_point;
	}
	public void setProduct_point(int product_point) {
		this.product_point = product_point;
	}
	public int getProduct_used() {
		return product_used;
	}
	public void setProduct_used(int product_used) {
		this.product_used = product_used;
	}
	@Override
	public String toString() {
		return "AdminProductVO [product_no=" + product_no + ", product_category=" + product_category + ", product_name="
				+ product_name + ", product_price=" + product_price + ", material_info=" + material_info + ", origin="
				+ origin + ", product_info=" + product_info + ", product_point=" + product_point + ", product_used="
				+ product_used + "]";
	}
	
	
	
}

package com.thisisthat.admin.product.vo;

public class AdminProductImageVO {

	private long product_no;
	private String upload_path;
	private String image_name;
	private int main_image;
	
	public long getProduct_no() {
		return product_no;
	}
	public void setProduct_no(long product_no) {
		this.product_no = product_no;
	}
	public String getUpload_path() {
		return upload_path;
	}
	public void setUpload_path(String upload_path) {
		this.upload_path = upload_path;
	}
	public String getImage_name() {
		return image_name;
	}
	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
	public int getMain_image() {
		return main_image;
	}
	public void setMain_image(int main_image) {
		this.main_image = main_image;
	}
	@Override
	public String toString() {
		return "AdminProductImageVO [product_no=" + product_no + ", upload_path=" + upload_path + ", image_name="
				+ image_name + ", main_image=" + main_image + "]";
	}
	
	
	
	
}

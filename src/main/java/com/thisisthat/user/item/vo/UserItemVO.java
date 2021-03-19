package com.thisisthat.user.item.vo;

public class UserItemVO {

	private long productNo;
	private String productName;
	private long productPrice;
	private String materialInfo;
	private String origin;
	private int xs;
	private int s;
	private int m;
	private int l;
	private int xl;
	
	public long getProductNo() {
		return productNo;
	}
	public void setProductNo(long productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}
	public String getMaterialInfo() {
		return materialInfo;
	}
	public void setMaterialInfo(String materialInfo) {
		this.materialInfo = materialInfo;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
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
	@Override
	public String toString() {
		return "UserItemVO [productNo=" + productNo + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", materialInfo=" + materialInfo + ", origin=" + origin + ", xs=" + xs + ", s=" + s + ", m=" + m
				+ ", l=" + l + ", xl=" + xl + "]";
	}
	
	
}

package com.thisisthat.admin.banner.vo;

public class BannerVO {
	private int bannerNo;
	private String bannerUri;
	private int bannerOrder;
	private String bannerName;
	
	
	
	@Override
	public String toString() {
		return "BannerVO [bannerNo=" + bannerNo + ", bannerUri=" + bannerUri + ", bannerOrder=" + bannerOrder
				+ ", bannerName=" + bannerName + "]";
	}
	public int getBannerNo() {
		return bannerNo;
	}
	public void setBannerNo(int bannerNo) {
		this.bannerNo = bannerNo;
	}
	public String getBannerUri() {
		return bannerUri;
	}
	public void setBannerUri(String bannerUri) {
		this.bannerUri = bannerUri;
	}
	public int getBannerOrder() {
		return bannerOrder;
	}
	public void setBannerOrder(int bannerOrder) {
		this.bannerOrder = bannerOrder;
	}
	public String getBannerName() {
		return bannerName;
	}
	public void setBannerName(String bannerName) {
		this.bannerName = bannerName;
	}
}

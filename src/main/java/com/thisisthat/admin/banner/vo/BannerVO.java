package com.thisisthat.admin.banner.vo;

public class BannerVO {
	private int bannerNo;
	private String bannerUri;
	private int bannerOrder;
	private String bannerName;
	private String bannerState;
	private String bannerLocation;
	
	
	
	@Override
	public String toString() {
		return "BannerVO [bannerNo=" + bannerNo + ", bannerUri=" + bannerUri + ", bannerOrder=" + bannerOrder
				+ ", bannerName=" + bannerName + ", bannerState=" + bannerState + ", bannerLocation=" + bannerLocation
				+ "]";
	}
	public String getBannerLocation() {
		return bannerLocation;
	}
	public void setBannerLocation(String bannerLocation) {
		this.bannerLocation = bannerLocation;
	}
	public String getBannerState() {
		return bannerState;
	}
	public void setBannerState(String bannerState) {
		this.bannerState = bannerState;
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

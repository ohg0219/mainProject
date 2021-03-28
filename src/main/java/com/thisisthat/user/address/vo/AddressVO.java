package com.thisisthat.user.address.vo;

public class AddressVO {

	private int addressNo;
	private String userId;
	private String addressName;
	private String receiveName;
	private String zipCode;
	private String firstAddress;
	private String lastAddress;
	private String userPhone;
	
	public int getAddressNo() {
		return addressNo;
	}
	public void setAddressNo(int addressNo) {
		this.addressNo = addressNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public String getReceiveName() {
		return receiveName;
	}
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getFirstAddress() {
		return firstAddress;
	}
	public void setFirstAddress(String firstAddress) {
		this.firstAddress = firstAddress;
	}
	public String getLastAddress() {
		return lastAddress;
	}
	public void setLastAddress(String lastAddress) {
		this.lastAddress = lastAddress;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	@Override
	public String toString() {
		return "AddressVO [addressNo=" + addressNo + ", userId=" + userId + ", addressName=" + addressName
				+ ", receiveName=" + receiveName + ", zipCode=" + zipCode + ", firstAddress=" + firstAddress
				+ ", lastAddress=" + lastAddress + ", userPhone=" + userPhone + "]";
	}
	
}

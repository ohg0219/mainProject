package com.thisisthat.user.answer.vo;

import java.util.Date;

public class SearchVO {
	private String searchDate;
	private String searchType;
	private String searchKeyword;
	private Date nowDate;
	public Date getNowDate() {
		return nowDate;
	}

	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}

	public SearchVO() {}
	
	public SearchVO(String searchDate, String searchType, String searchKeyword) {
		this.searchDate = searchDate;
		this.searchType = searchType;
		this.searchKeyword = searchKeyword;
	}
	public String getSearchDate() {
		return searchDate;
	}
	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
}

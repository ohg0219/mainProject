package com.thisisthat.admin.notice.vo;

public class SearchVO {
	private String searchOption;
	private String keyword;
	public String getSearchOption() {
		return searchOption;
	}
	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public SearchVO(String searchOption, String keyword) {
		this.searchOption = searchOption;
		this.keyword = keyword;
	}
	
	public SearchVO() {
		
	}

}

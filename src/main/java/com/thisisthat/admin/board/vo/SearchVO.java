package com.thisisthat.admin.board.vo;

public class SearchVO {
	private String type;
	private String searchType;
	private String parameter;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public SearchVO(String type, String searchType, String parameter) {

		this.type = type;
		this.searchType = searchType;
		this.parameter = parameter;
	}
	public SearchVO() {
		// TODO Auto-generated constructor stub
	}
	
	
}

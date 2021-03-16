package com.thisisthat.admin.board.protocol;

public class BoardTypeProtocol {
	
	
	public static String filter(String type) {
		String result="";
		switch (type) {
		case "product":
			result="%상품문의%";
			break;
		case "delivery":
			result="%배송문의%";
			break;
		case "other":
			result="%기타문의%";
			break;
			
		default:
			result ="%%";
			break;
		}
		
		return result;
	}
}

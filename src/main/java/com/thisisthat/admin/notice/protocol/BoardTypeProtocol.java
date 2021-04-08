package com.thisisthat.admin.notice.protocol;

public class BoardTypeProtocol {
	
	public static String filter(String type) {
		String result="all";
		switch(type) {
		case "board_writer": 
			result="board_writer";
			break;
		case "board_title" : 
			result="board_title";
			break;
		case "board_content" : 
			result="board_content";
			break;
		default : 
			result="";
			break;
		}
		return result;
	}

}

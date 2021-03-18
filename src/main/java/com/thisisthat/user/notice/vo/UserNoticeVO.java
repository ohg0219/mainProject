package com.thisisthat.user.notice.vo;

import java.util.Date;

public class UserNoticeVO {
	private int board_no;
	private String board_title;
	private String board_content;
	private String board_writer;
	private Date reg_date;
	private int board_cnt;
	private String board_group;
	private String board_img;
	private boolean board_view;
	private String keyword;
	private String user_id;
	private String nick_name;

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public String getBoard_writer() {
		return board_writer;
	}

	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public int getBoard_cnt() {
		return board_cnt;
	}

	public void setBoard_cnt(int board_cnt) {
		this.board_cnt = board_cnt;
	}

	public String getBoard_group() {
		return board_group;
	}

	public void setBoard_group(String board_group) {
		this.board_group = board_group;
	}

	public String getBoard_img() {
		return board_img;
	}

	public void setBoard_img(String board_img) {
		this.board_img = board_img;
	}

	public boolean isBoard_view() {
		return board_view;
	}

	public void setBoard_view(boolean board_view) {
		this.board_view = board_view;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	@Override
	public String toString() {
		return "UserNoticeVO [board_no=" + board_no + ", board_title=" + board_title + ", board_content="
				+ board_content + ", board_writer=" + board_writer + ", reg_Date=" + reg_date + ", board_cnt="
				+ board_cnt + ", board_group=" + board_group + ", board_img=" + board_img + ", board_view=" + board_view
				+ ", keyword=" + keyword + ", user_id=" + user_id + ", nick_name=" + nick_name + "]";
	}

}

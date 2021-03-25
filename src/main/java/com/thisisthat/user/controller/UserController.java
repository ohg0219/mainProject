package com.thisisthat.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	/**
	 * 메인페이지로 이동
	 * @return
	 */
	@RequestMapping(value = {"main.do"})
	public String mainView() {
		return "/user/main";
	}
	
	/**
	 * 공지사항 페이지로 이동
	 * @return
	 */
	@RequestMapping("/notice.do")
	public String noticeView() {
		return "/user/notice";
	}
	
	
}

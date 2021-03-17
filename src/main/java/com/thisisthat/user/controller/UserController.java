package com.thisisthat.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	 * 로그인페이지로 이동
	 * @return
	 */
	@RequestMapping(value = {"/login.do"})
	public String loginView(HttpSession session) {
		if(session.getAttribute("userId")!=null || session.getAttribute("kakaoUserId") != null || 
				session.getAttribute("naverUserId") != null || session.getAttribute("googleUserId") != null) {
			return "redirect:/main.do";
		}
		return "/user/login";
	}
	/**
	 * 회원가입페이지로 이동
	 * @return
	 */
	@GetMapping(value = {"/register.do"})
	public String registerView() {
		return "/user/register";
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

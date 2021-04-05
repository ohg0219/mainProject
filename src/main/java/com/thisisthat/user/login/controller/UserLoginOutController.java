package com.thisisthat.user.login.controller;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.user.login.service.UserLoginOutService;

@Controller
public class UserLoginOutController {
	
	@Autowired
	private UserLoginOutService userLoginOutService;
	
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
		return "/user/loginAndRegister/login";
	}
	
	/**
	 * 회원 로그인 처리 (로그인시 세션에 저장)
	 * @param id
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping("/loginCheck.do")
	public String loginCheck(
			@RequestParam("id")String id,
			@RequestParam("password")String password,
			HttpSession session) {
		String dbPass = userLoginOutService.userLogin(id);
		if(dbPass==null) {//아이디없음
			return "redirect:/login.do";
		}else {
			if(BCrypt.checkpw(password, dbPass)) {
				session.removeAttribute("basketItem");
				session.setAttribute("userId", id);
				return "redirect:/main.do";
			}else {
				return "redirect:/login.do";
			}
		}
	}
	/**
	 * 회원 로그아웃 처리 (로그아웃시 세션 종료)
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("userId");
		session.removeAttribute("naverUserId");
		if(session.getAttribute("kakaoUserId")!=null) {
			return "redirect:https://kauth.kakao.com/oauth/logout?client_id=7ff3d3c85953e4c8234ff377259bd06b&logout_redirect_uri=http://localhost:8080/kakaologout.do";
		}
		return "redirect:/main.do";
	}
	
}

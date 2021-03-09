package com.thisisthat.user.login.controller;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.user.register.service.UserLoginOutService;

@Controller
public class UserLoginOutController {
	
	@Autowired
	private UserLoginOutService userLoginService;
	
	@RequestMapping("/loginCheck.do")
	public String loginCheck(
			@RequestParam("id")String id,
			@RequestParam("password")String password,
			HttpSession session) {
		String dbPass = userLoginService.userLogin(id);
		if(dbPass==null) {//아이디없음
			System.out.println("로그인 실패");
			return "redirect:/login.do";
		}else {
			if(BCrypt.checkpw(password, dbPass)) {
				System.out.println("로그인 성공");
				session.setAttribute("userId", id);
				return "redirect:/main.do";
				
			}else {
				System.out.println("로그인 실패");
				return "redirect:/login.do";
			}
		}
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main.do";
	}
}

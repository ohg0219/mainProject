package com.thisisthat.admin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.admin.banner.vo.BannerVO;
import com.thisisthat.admin.notice.service.NoticeService;
import com.thisisthat.admin.notice.vo.NoticeVO;
import com.thisisthat.admin.service.AdminService;
import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.user.register.vo.TestVO;

@Controller

public class AdminController {
	
	@Autowired
	AdminService dao;

	@RequestMapping("/admin/main.mdo")
	public String mainView(Model model) {
		
		return "/admin/main";
	}

	@RequestMapping("/login.mdo")
	public String loginView() {
		return "/admin/login";
	}
	@RequestMapping("/admin/logout.mdo")
	public String removeSession(HttpSession session, HttpServletResponse response) {
		Cookie cookie = new Cookie("userVO", null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		session.invalidate();
		return "/admin/login";
	}

	@PostMapping("/login.mdo")
	public String loginCheck(UserVO vo, HttpSession session,Model model,
			@RequestParam(value="autoLogin",defaultValue= "false")boolean autoLogin,
			HttpServletResponse response) {
		UserVO user = dao.idCheck(vo.getUserId());
		if(user == null) {
			
		}else if(BCrypt.checkpw(vo.getUserPw(), user.getUserPw())) {
			if(user.getUserRole()<21) {
				session.setAttribute("adminId", user);
				if(autoLogin) {
					Cookie cookie = new Cookie("userVO", user.getUserId());
					cookie.setMaxAge(60*60*24*30);//한달설정
					cookie.setPath("/");
					response.addCookie(cookie);
				}
				return "/admin/main";
			}else {
				model.addAttribute("msg","roleFail");
				return "/admin/login";
			}
		}
		
		model.addAttribute("msg","pwFail");
		return "/admin/login";
	}
	
	

	
	@GetMapping("userManagement.mdo")
	public String userManagement() {
		
		return "/admin/userManagement";
	}
}

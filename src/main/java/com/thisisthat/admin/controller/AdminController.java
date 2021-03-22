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
	public String mainView() {
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
		System.out.println(autoLogin);
		if(user == null) {
			
		}else if(BCrypt.checkpw(vo.getUserPw(), user.getUserPw())) {
			if(user.getUserRole()<21) {
				session.setAttribute("userId", user);
				if(autoLogin) {
					System.out.println("쿠키");
					Cookie cookie = new Cookie("userVO", user.getUserId());
					cookie.setMaxAge(60*60*24*30);//한달설정
					cookie.setPath("/");
					response.addCookie(cookie);
				}
				return "/admin/main";
			}else {
				System.out.println("권한없음");
				model.addAttribute("msg","roleFail");
				return "/admin/login";
			}
		}
		
		System.out.println("로그인 실패");
		model.addAttribute("msg","pwFail");
		return "/admin/login";
	}

	@GetMapping("/admin/articleList.mdo")
	public String notice(Model model,@RequestParam(value="where")String where) {
		List<TestVO> voList = new ArrayList<TestVO>();
		for(int i = 1; i<=10; i++) {
			TestVO vo = new TestVO();
			vo.setCnt(new Long(i));
			vo.setRegDate(new Date());
			vo.setSeq(new Long(i));
			vo.setTitle(i+"제목");
			vo.setWriter(i+"작성자");
			voList.add(vo);
		}
		model.addAttribute("articleList",voList);
		model.addAttribute("where", where);
		return "/admin/articleList";
	}

	@GetMapping("/admin/articleGate.mdo")
	public String articleGate(@RequestParam(value="where")String where) {
		return "redirect:/admin/articleList.mdo?where="+where;
	}

	@GetMapping("/admin/insertArticle.mdo")
	public String insertArticle() {
		return "/admin/insertArticle";
	}
	

	
	@GetMapping("userManagement.mdo")
	public String userManagement() {
		
		return "/admin/userManagement";
	}
}

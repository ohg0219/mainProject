	package com.thisisthat.user.mypage.controller;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.user.mypage.service.MyPageService;
import com.thisisthat.user.register.vo.UserRegisterVO;

@Controller
public class MyPageController {

	@Autowired
	private MyPageService service;

	@RequestMapping("/mypage/modify.do")
	public String modifyView(HttpSession session, Model model) {
		String id = null;
		if (session.getAttribute("userId") != null)
			id = (String) session.getAttribute("userId");
		System.out.println(id);
		UserRegisterVO user = service.modifyView(id);
		if(user.getPhone()!=null) {
			String phone1 = user.getPhone().substring(0, 3);
			String phone2 = user.getPhone().substring(3, 7);
			String phone3 = user.getPhone().substring(7, 11);
			model.addAttribute("phone1", phone1);
			model.addAttribute("phone2", phone2);
			model.addAttribute("phone3", phone3);
		}
		model.addAttribute("modify", user);
		System.out.println(user.toString());
		return "/user/mypage/modify";
	}
	
	@PostMapping("/mypage/mypageModify.do")
	public String myPageModify(Model model, UserRegisterVO vo, 
								@RequestParam("phone1") String phone1,
								@RequestParam("phone2") String phone2,
								@RequestParam("phone3") String phone3,
								@RequestParam("password") String password){
		vo.setPhone(phone1 + phone2 + phone3);
		vo.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
		service.modify(vo);
		
		return "redirect:/mypage/modify.do";
	}
	
	@RequestMapping("/mypage/mypage.do")
	public String mypageMain(HttpSession session, Model model) {
		String id = null;
		if (session.getAttribute("userId") != null)
			id = (String) session.getAttribute("userId");
		System.out.println(id);
		UserRegisterVO user = service.modifyView(id);
		model.addAttribute("modify", user);
		return "/user/mypage/myMain";
	}
	
	
	
	
	

}

package com.thisisthat.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thisisthat.admin.banner.vo.BannerVO;
import com.thisisthat.user.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	/**
	 * 메인페이지로 이동
	 * @return
	 */
	@RequestMapping(value = {"main.do"})
	public String mainView(Model model) {
		for(BannerVO vo : userService.getBannerList()) {
			System.out.println(vo.toString());
		}
		model.addAttribute("bannerList",userService.getBannerList());
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

package com.thisisthat.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String mainView(Model model, @RequestParam(value="msg", required = false)String msg) {
		model.addAttribute("MainBannerList",userService.getBannerList("main"));
		model.addAttribute("subBannerList",userService.getBannerList("sub"));
		
		if(msg != null) model.addAttribute("msg",msg);
		return "/user/main";
	}
	
	@GetMapping("/terms.do")
	public String terms(Model model) {
		model.addAttribute("utilization",userService.getUtilization());
		return "/user/terms";
	}
	@GetMapping("/privacy.do")
	public String privacy(Model model) {
		model.addAttribute("privacy",userService.getPrivacy());
		return "/user/privacyPolicy";
	}
	
}

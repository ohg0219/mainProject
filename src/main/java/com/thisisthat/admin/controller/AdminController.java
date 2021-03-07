package com.thisisthat.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping("/main.mdo")
	public String mainView() {
		return "/admin/main";
	}
	
	@RequestMapping("/login.mdo")
	public String loginView() {
		return "/admin/login";
	}
}

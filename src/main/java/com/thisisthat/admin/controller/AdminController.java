package com.thisisthat.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.admin.notice.service.NoticeService;
import com.thisisthat.admin.notice.vo.NoticeVO;

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
	
	


	
	@GetMapping("userManagement.mdo")
	public String userManagement() {
		
		return "/admin/userManagement";
	}
}

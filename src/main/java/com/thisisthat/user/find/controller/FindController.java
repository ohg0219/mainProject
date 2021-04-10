package com.thisisthat.user.find.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FindController {

	/*
	 * 아이디, 비밀번호 찾기 눌렀을 때 이동하는 컨트롤러 
	 */
	@GetMapping("/findIdPassword.do")
	public String FindIdPw() {
		return "/user/find/findIdPassword";
	}
	
	
}




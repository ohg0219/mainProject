package com.thisisthat.user.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thisisthat.user.register.service.UserRegisterService;

@Controller
public class UserRegisterController {

	@Autowired
	UserRegisterService userRegisterService;
	
	/**
	 * 회원가입 처리후 메인 페이지이동
	 * @return
	 */
	@PostMapping("/regist.do")
	public String regist() {
		//회원가입 로직 처리
		return "redirect:main.do";
	}
	
	/**
	 * 아이디 중복 실시간 체크 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/user/idCheck.do",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String idCheck(@RequestParam("userId") String userId) {
		return String.valueOf(userRegisterService.idCheck(userId));
	}
}

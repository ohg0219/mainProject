package com.thisisthat.user.register.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thisisthat.user.register.service.UserRegisterService;
import com.thisisthat.user.register.vo.UserRegisterVO;

@Controller
public class UserRegisterController {

	
	@Autowired
	UserRegisterService userRegisterService;
	
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
	
	/**
	 * 닉네임 중복 실시간 체크
	 * @param nickName
	 * @return
	 */
	@RequestMapping(value="/user/nickNameCheck.do",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String nickNameCheck(@RequestParam("nickName") String nickName) {
		return String.valueOf(userRegisterService.nickNameCheck(nickName));
	}
	/**
	 * 회원가입 처리후 메인 페이지이동
	 * @return
	 */
	@PostMapping("/regist.do")
	public String insertUser(UserRegisterVO vo,
			@RequestParam("phone1")String phone1,
			@RequestParam("phone2")String phone2,
			@RequestParam("phone3")String phone3,
			@RequestParam("password")String password
			) {
		vo.setPhone(phone1+phone2+phone3);
		vo.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
		userRegisterService.insertUser(vo);
		return "redirect:/user/joinResult";
	}
	
	
}

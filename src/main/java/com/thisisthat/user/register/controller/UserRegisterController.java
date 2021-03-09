package com.thisisthat.user.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	 * �쉶�썝媛��엯 泥섎━�썑 硫붿씤 �럹�씠吏��씠�룞
	 * @return
	 */
	@RequestMapping("/joinResult.do") 
	public String register() { //Model model, UserRegisterVO registerVO) {
//		userRegisterService.
		return "/user/joinResult";
	}
	
	/**
	 * �븘�씠�뵒 以묐났 �떎�떆媛� 泥댄겕 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/user/idCheck.do",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String idCheck(@RequestParam("userId") String userId) {
		return String.valueOf(userRegisterService.idCheck(userId));
	}
}

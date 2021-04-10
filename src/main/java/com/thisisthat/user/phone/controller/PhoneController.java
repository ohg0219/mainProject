package com.thisisthat.user.phone.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.user.phone.service.PhoneService;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Controller
public class PhoneController {

	@Autowired
	private PhoneService service;

	// 폰번호로 아이디 찾기
	@GetMapping("/sendIdPhone.do")
	public String FindIdPhone(HttpServletRequest request, Model model, Map<String, Object> map,
			HashMap<String, String> param, @RequestParam(value = "name") String name,
			@RequestParam(value = "phone1") String phone1, @RequestParam(value = "phone2") String phone2,
			@RequestParam(value = "phone3") String phone3) throws Exception {

		String api_key = "NCSRPUTRTVS4PDHD";
		String api_secret = "DHJTB1HGL7X2KNUB13PUURLTUQJEXP7P";
		Message coolsms = new Message(api_key, api_secret);

		map.put("name", name);
		map.put("phone", phone1 + phone2 + phone3);

		List<String> userId = service.IdPhone(map);

		if (userId.isEmpty()) {
			model.addAttribute("errType", "mailSendingFail");
			model.addAttribute("errMsg", "입력하신 정보로 가입된 회원은 존재하지 않습니다.");
			return "/user/find/findFail";

		} else {
			param.put("from", "01030561121");
			param.put("to", phone1 + phone2 + phone3);
			param.put("type", "sms");
			param.put("text", "고객님의 아이디는\n" + userId.toString() + "입니다.\n감사합니다.\n-thisisthat-");
			param.put("app_version", "tes t app 2.2");
		}

		try {
			JSONObject obj = (JSONObject) coolsms.send(param);
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
		model.addAttribute("errType", "mailSendingFail");
		model.addAttribute("errMsg", "입력하신 휴대폰 번호로 아이디 정보가 전송되었습니다.");
		return "/user/find/findView";
	}

	
	@GetMapping("/sendPwPhone.do")
	public String FindPwPhone(	Map<String, Object> map, Model model, 
								HashMap<String, String> param,
								@RequestParam(value = "id") String id,
								@RequestParam(value = "name") String name, 
								@RequestParam(value = "phone1") String phone1,
								@RequestParam(value = "phone2") String phone2, 
								@RequestParam(value = "phone3") String phone3) {
		String api_key = "NCSRPUTRTVS4PDHD";
		String api_secret = "DHJTB1HGL7X2KNUB13PUURLTUQJEXP7P";
		Message coolsms = new Message(api_key, api_secret);

		int pw = (int) (Math.random() * 100000000);

		map.put("id", id);
		map.put("name", name);
		map.put("phone", phone1 + phone2 + phone3);
		String pass = service.PwPhone(map);
		if (pass != null) {

			param.put("to", phone1 + phone2 + phone3);
			param.put("from", "01030561121");
			param.put("type", "SMS");
			param.put("text", "회원님의 임시 비밀번호는 " + pw + "입니다.\n감사합니다.\n-thisisthat-");
			param.put("app_version", "test app 2.2");
			
		} else {
			model.addAttribute("errType", "mailSendingFail");
			model.addAttribute("errMsg", "입력하신 정보로 가입된 회원이 존재하지 않습니다.");
			return "/user/find/findFail";
		}
		
		try {
			JSONObject obj = (JSONObject) coolsms.send(param);
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}		
		model.addAttribute("errType", "mailSendingFail");
		model.addAttribute("errMsg", "핸드폰번호로 임시 비밀번호를 발급하였습니다.");
		model.addAttribute("id", id);
		model.addAttribute("pass", pw);
		return "/user/find/findPw";
	}
	

	
	
	
	
	
}
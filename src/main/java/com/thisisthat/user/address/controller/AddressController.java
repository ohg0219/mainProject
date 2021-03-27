package com.thisisthat.user.address.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddressController {

	
	@GetMapping("/mypage/address.do")
	public String getAddress() {
		return "/user/mypage/getAddress";
	}
	
	
	
	
}

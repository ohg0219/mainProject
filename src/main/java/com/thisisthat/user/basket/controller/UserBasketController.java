package com.thisisthat.user.basket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserBasketController {

	//화면 확인용 메서드
	@RequestMapping("/testBasket.do")
	public String basketView() {
		return "/user/basket";
	}
}

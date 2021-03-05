package com.one.thisisthat.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	/**
	 * 메인페이지로 이동
	 * @return
	 */
	@RequestMapping(value = {"/{page}.do"})
	public String mainView(@PathVariable String page) {
		System.out.println(page+"로");
		return "/user/"+page;
	}
	/**
	 * 상품 리스트 페이지로 이동
	 * @param category
	 * @return
	 */
	@RequestMapping("/shop/list/{category}.do")
	public String itemListView(@PathVariable String category) {
		System.out.println(category);
		return "/user/itemList/"+category;
	}
	
	
	
}

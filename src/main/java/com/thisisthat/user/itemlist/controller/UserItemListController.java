package com.thisisthat.user.itemlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.user.itemlist.sevice.UserItemListService;
import com.thisisthat.user.itemlist.vo.UserItemListVO;

@Controller
public class UserItemListController {

	
	@Autowired
	private UserItemListService itemListService;
	/**
	 * 상품 리스트 페이지로 이동
	 * @param category
	 * @return
	 */
	@GetMapping("/itemList/category/{category}.do")
	public String itemListView(@PathVariable String category,Model model) {
		System.out.println(category);
		List<UserItemListVO> itemList = itemListService.getItemList(category);
		model.addAttribute("itemList",itemList);
		model.addAttribute("category",category);
		return "/user/item/itemList";
	}
	
	@GetMapping("/itemList/getItem.do")
	public String getItem(
			@RequestParam("productNo") int productNo,
			@RequestParam("productCategory")String productCategory,
			Model model) {
		model.addAttribute("category",productCategory);
		return "/user/item/getItem";
	}
	
}

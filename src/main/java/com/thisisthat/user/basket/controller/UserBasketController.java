package com.thisisthat.user.basket.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.user.basket.service.UserBasketItemService;
import com.thisisthat.user.basket.vo.UserBasketItemVO;

@Controller
public class UserBasketController {

	@Autowired
	private UserBasketItemService basketItemService;

	/**
	 * 장바구니 목록 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/basket.do")
	public String basketList(HttpSession session,Model model) {
		if(session.getAttribute("userId")!=null) {
			String userId = (String) session.getAttribute("userId");
			model.addAttribute("basketList",basketItemService.getBasketList(userId));
		}
		return "/user/basket";
	}
	/**
	 * 장바구니에 담기 버튼 (비회원의 경우 세션에, 회원의 경우 basket 테이블에 저장)
	 * @param session
	 * @param productNo
	 * @param selectItem
	 * @param productPrice
	 * @return
	 */
	@GetMapping("/insertbasket.do")
	public String insertBasket(HttpSession session,
			@RequestParam("productNo")long productNo,
			@RequestParam("selectItem")String selectItem,
			@RequestParam("productPrice")long productPrice) {
		String[] sizeAndCount = selectItem.split("/");
		List<UserBasketItemVO> basketItemList = new ArrayList<UserBasketItemVO>();
		for(int i = 0;i<sizeAndCount.length;i++) {
			String[] split = sizeAndCount[i].split(":");
			UserBasketItemVO basketItemVO = basketItemService.getItemInfo(productNo);
			basketItemVO.setProductNo(productNo);
			basketItemVO.setSelectSize(split[0]);
			basketItemVO.setSelectCount(Integer.parseInt(split[1]));
			basketItemVO.setProductPrice(productPrice);
			basketItemList.add(basketItemVO);
		}
		if(session.getAttribute("userId")==null) {
			session.setAttribute("basketItem", basketItemList);
		}else {
			String userId = (String) session.getAttribute("userId");
			for(UserBasketItemVO vo : basketItemList) {
				vo.setUserId(userId);
			}
			basketItemService.insertBasket(basketItemList);
		}
		return "redirect:/basket.do";
	}
	
	
	
	
	
	
}

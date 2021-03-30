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
import org.springframework.web.bind.annotation.ResponseBody;

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
		return "/user/payment/basket";
	}
	/**
	 * 회원 장바구니 상품 삭제
	 * @param session
	 * @param vo
	 * @return
	 */
	@GetMapping("/deleteUserBasket.do")
	public String deleteUserBasket(HttpSession session,UserBasketItemVO vo) {
		vo.setUserId((String) session.getAttribute("userId"));
		basketItemService.deleteUserBasket(vo);
		return "redirect:/basket.do";
	}
	/**
	 * 회원 장바구니 수량 변경
	 * @param vo
	 * @return
	 */
	@GetMapping("/updateUserBasket.do")
	public String updateUserBasket(UserBasketItemVO vo) {
		basketItemService.updateUserBasket(vo);
		return "redirect:/basket.do";
	}
	/**
	 * 비회원 세션 장바구니 상품 삭제
	 * @param session
	 * @param vo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/deleteBasket.do")
	public String deleteBasket(HttpSession session,UserBasketItemVO vo) {
		//세션을 가져와서 해당하는 상품 삭제
		long productNo = vo.getProductNo();
		String selectSize = vo.getSelectSize();
		List<UserBasketItemVO> basketItem = (List<UserBasketItemVO>) session.getAttribute("basketItem");
		for(int i = 0; i <basketItem.size();i++) {
			UserBasketItemVO basket = basketItem.get(i);
			if(basket.getProductNo()==productNo && basket.getSelectSize().equals(selectSize)) {
				basketItem.remove(i);
			}
		}
		return "redirect:/basket.do";
	}
	/**
	 * 비회원 세션 장바구니 수량 변경
	 * @param session
	 * @param vo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/updateBasket.do")
	public String updateBasket(HttpSession session,UserBasketItemVO vo) {
		long productNo = vo.getProductNo();
		String selectSize = vo.getSelectSize();
		List<UserBasketItemVO> basketItem = (List<UserBasketItemVO>) session.getAttribute("basketItem");
		for(int i = 0;i < basketItem.size();i++) {
			if(productNo == basketItem.get(i).getProductNo() && selectSize.equals(basketItem.get(i).getSelectSize())) {
				if(vo.getType().equals("plus")) {
					basketItem.get(i).setSelectCount(basketItem.get(i).getSelectCount()+1);
				}else {
					basketItem.get(i).setSelectCount(basketItem.get(i).getSelectCount()-1);
				}
			}
		}
		return "redirect:/basket.do";
	}
	
	/**
	 * 장바구니 상품 등록
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/insertBasket.do")
	@ResponseBody
	public String insertBasket(HttpSession session,
			@RequestParam("productNo")long productNo,
			@RequestParam("selectItem")String selectItem) {
		String[] sizeAndCount = selectItem.split("/");
		List<UserBasketItemVO> getItemList = new ArrayList<UserBasketItemVO>();
		for(int i = 0;i<sizeAndCount.length;i++) {
			String[] split = sizeAndCount[i].split(":");
			UserBasketItemVO basketItemVO = basketItemService.getItemInfo(productNo);
			basketItemVO.setProductNo(productNo);
			basketItemVO.setSelectSize(split[0]);
			basketItemVO.setSelectCount(Integer.parseInt(split[1]));
			getItemList.add(basketItemVO);
		}
		if(basketItemService.getProductStock(getItemList) == false) {
			return "stockOver";
		}else{
			//회원 장바구니 추가 + 중복체크
			if(session.getAttribute("userId")!=null) {
				String userId = (String) session.getAttribute("userId");
				List<UserBasketItemVO> dbBasketList = basketItemService.getBasketList(userId);
				for(UserBasketItemVO dbBasket : dbBasketList) {
					for(UserBasketItemVO getItem : getItemList) {
						if(dbBasket.getProductNo() == getItem.getProductNo()
								&& dbBasket.getSelectSize().equals(getItem.getSelectSize())) {
							return "fail";
						}
					}
				}
				for(UserBasketItemVO vo : getItemList) {
					vo.setUserId(userId);
				}
				basketItemService.insertBasket(getItemList);
			}else {//비회원 장바구니 추가 + 중복체크
				//비회원 장바구니 존재시
				if(session.getAttribute("basketItem")!=null) {
					List<UserBasketItemVO> basketItem = (List<UserBasketItemVO>) session.getAttribute("basketItem");
					for(UserBasketItemVO basket : basketItem) {
						for(UserBasketItemVO getItem : getItemList) {
							if(basket.getProductNo() == getItem.getProductNo()
									&& basket.getSelectSize().equals(getItem.getSelectSize())) {
								return "fail";
							}
						}
					}
					basketItem.addAll(getItemList);
				}else {
					session.setAttribute("basketItem", getItemList);
				}
			}
		};
		return "ok";
	}
	
	
}

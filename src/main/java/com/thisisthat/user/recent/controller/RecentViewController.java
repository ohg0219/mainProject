package com.thisisthat.user.recent.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.user.basket.vo.UserBasketItemVO;
import com.thisisthat.user.recent.service.RecentViewServiceImpl;
import com.thisisthat.user.recent.vo.DbBasketItemVO;
import com.thisisthat.user.recent.vo.RecentBasketVO;
import com.thisisthat.user.recent.vo.RecentViewVO;

@Controller
public class RecentViewController {

	@Autowired
	private RecentViewServiceImpl service;

	// 최근 본 상품 아이콘 눌렀을 때
	@RequestMapping("/recentView.do")
	public String RecentView() {
		return "redirect:/recentInfo.do";
	}

	// 목록 불러오기
	@RequestMapping("/recentInfo.do")
	public String Recent(RecentViewVO vo, Model model, HttpSession session) {

		ArrayList<Integer> list = (ArrayList<Integer>) session.getAttribute("productNo");
		List<RecentViewVO> product = new ArrayList<RecentViewVO>();

		if (list != null) {
			for (int productNo : list) {
				vo.setProductNo(productNo);
				RecentViewVO productInfo = service.itemView(vo);
				product.add(productInfo);
			}
			model.addAttribute("imgView", product);

		} else {
			model.addAttribute("imgView", null);
		}
		return "/user/recentView";
	}

	@RequestMapping("/deleteRecent.do")
	public String deleteRecent(HttpSession session, @RequestParam(value = "productNo") int productNo) {

		ArrayList<Integer> list = (ArrayList<Integer>) session.getAttribute("productNo");

		list.remove((Integer) productNo);
		session.setAttribute("productNo", list);
		return "redirect:/recentInfo.do";
	}

	// 최근본 상품을 장바구니에 담기
	@GetMapping("/insertRecentBasket.do")
	public String insertBasket(HttpSession session, Model model, RecentViewVO vo, RecentBasketVO bo,
									@RequestParam(value = "productNo") int productNo, 
									@RequestParam(value = "size") String selectSize,
									@RequestParam(value = "productPrice") int productPrice) {
		boolean flag = false;
		String userId = (String) session.getAttribute("userId");

		List<DbBasketItemVO> dbbasketList = service.getRecentBasketList(userId);

		// 회원 + 중복 상품 확인
		if (session.getAttribute("userId") != null) {
			for (DbBasketItemVO basket : dbbasketList) {
				if (basket.getProductNo() == productNo && basket.getSelectSize().equals(selectSize)) {
						System.out.println(productNo);
						System.out.println(basket.getProductNo());
						System.out.println(selectSize);
						System.out.println(basket.getSelectSize());
						flag = true;
						break;
				}
			}

			if (flag == true) {
				model.addAttribute("errMsg", "장바구니에 중복된 상품이 있습니다.");
				return "/user/recentBasketFail";

			} else {
				// 사이즈 선텍 확인
				if (selectSize.equals("*")) {
					model.addAttribute("errMsg", "사이즈를 선택해주세요");
					return "user/recentSizeFail";
				} else {
					bo.setUserId(userId);
					bo.setProductNo(productNo);
					bo.setSelectCount(1);
					bo.setProductPrice(productPrice);
					bo.setSelectSize(selectSize);
					service.insertBasket(bo);
				}
			}
			return "redirect:/basket.do";
			
		// 비회원 + 중복 상품 확인
		} else {
			boolean check = false;
			if (session.getAttribute("basketItem") != null) {
				List<UserBasketItemVO> basket = (List<UserBasketItemVO>) session.getAttribute("basketItem");
				for(UserBasketItemVO basketItem : basket) {
					if(basketItem.getProductNo() == productNo && basketItem.getSelectSize().equals(selectSize)) {
							check = true;
							break;
					}
				}
			}
			
			// 중복 상품이 없을 시
			if(check != true) {
				if(selectSize.equals("*")) {
					model.addAttribute("errMsg", "사이즈를 선택해주세요");
					return "user/recentSizeFail";
					
				} else {					
					bo.setProductNo(productNo);
					bo.setSelectCount(1);
					bo.setProductPrice(productPrice);
					bo.setSelectSize(selectSize);
					session.setAttribute("basketItem", bo);
				}
				return "redirect:/basket.do";
			
			} else {
				model.addAttribute("errMsg", "장바구니에 동일한 상품이 있습니다");
				return "/user/recentBasketFail";
			}
		}
	}
		
}

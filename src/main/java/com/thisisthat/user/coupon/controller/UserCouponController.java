package com.thisisthat.user.coupon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.user.coupon.service.UserCouponService;
import com.thisisthat.util.PagingVO;

@Controller
public class UserCouponController {

	@Autowired
	private UserCouponService couponService;
	
	@GetMapping("/mypage/coupon.do")
	public String getCouponList(HttpSession session,Model model,
			@RequestParam(value = "nowPage",required = false,defaultValue = "1") int nowPage) {
		String userId = (String) session.getAttribute("userId");
		int count = couponService.getCouponCount(userId);
		PagingVO pagingvo = new PagingVO(count, nowPage, 10);
		model.addAttribute("couponList",couponService.getCouponList(userId, pagingvo));
		model.addAttribute("paging",pagingvo);
		return "/user/mypage/coupons";
	}
	
}

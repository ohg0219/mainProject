package com.thisisthat.admin.coupon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thisisthat.admin.coupon.service.CouponService;
import com.thisisthat.admin.coupon.vo.CouponVO;

@Controller
@RequestMapping("/admin/*")
public class CouponController {
	
	@Autowired
	private CouponService couponService;
	
	@RequestMapping("couponList.mdo")
	public String couponList(Model model) {
		CouponVO couponVO = new CouponVO();
		List<CouponVO> couponList = couponService.couponList(couponVO);
		
		model.addAttribute("couponList",couponList);
		return "/admin/coupon/couponList";
	}//end couponList

	
	@RequestMapping("insertCoupon.mdo")
	public String insertCoupon() {
		return "/admin/coupon/insertCoupon";
	}
	
	
	
}//end class

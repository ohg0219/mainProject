package com.thisisthat.admin.coupon.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.admin.coupon.service.CouponService;
import com.thisisthat.admin.coupon.vo.CouponVO;

@Controller
@RequestMapping("/admin/*")
public class CouponController {

	@Autowired
	private CouponService couponService;

	@RequestMapping("getCouponList.mdo")
	public String getCouponList(Model model) {
		CouponVO couponVO = new CouponVO();
		List<CouponVO> couponList = couponService.couponList(couponVO);

		model.addAttribute("couponList", couponList);
		return "/admin/coupon/couponList";
	}// end couponList

	@GetMapping("insertCoupon.mdo")
	public String insertCoupon() {
		return "/admin/coupon/insertCoupon";
	}

	@RequestMapping("couponSearch.mdo")
	public String couponSearch(Model model, @RequestParam(value = "searchOption") String searchOption,
			@RequestParam(value = "keyword") String keyword, CouponVO couponVO) {
		if (searchOption.equals("coupon_name")) {
			couponVO.setKeyword(keyword);
			List<CouponVO> couponList = couponService.nameSearch(couponVO);
			model.addAttribute("couponList", couponList);
			return "/admin/coupon/couponList";
		} else if (searchOption.equals("coupon_first")) {

		} else if (searchOption.equals("coupon_last")) {

		}

		return null;
	}

	@RequestMapping("viewCoupon.mdo")
	public String viewCoupon(Model model, @RequestParam(value = "coupon_no") int coupon_no, CouponVO couponVO) {
		CouponVO viewCoupon = couponService.viewCoupon(couponVO);

		model.addAttribute("article", viewCoupon);
		return "/admin/coupon/viewCoupon";
	}

	@PostMapping("insertCoupon.mdo")
	public String insertCoupon(CouponVO couponVO, @RequestParam(value = "first") String first,
			@RequestParam(value = "last") String last) throws Exception {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmm");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmm");

		Date coupon_first = sdf1.parse(first);
		couponVO.setCoupon_first(coupon_first);

		Date coupon_last = sdf2.parse(last);
		couponVO.setCoupon_last(coupon_last);

		System.out.println(couponVO.toString());
		couponService.insertCoupon(couponVO);
		return "redirect:getCouponList.mdo";
	}

}// end class

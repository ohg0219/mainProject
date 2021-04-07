package com.thisisthat.admin.coupon.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.admin.coupon.service.CouponService;
import com.thisisthat.admin.coupon.vo.CouponVO;
import com.thisisthat.util.PagingVO;

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

	
	
	
	@RequestMapping("insertCoupon.mdo")
	public String insertCoupon() {
		return "/admin/coupon/insertCoupon";
	}

	@RequestMapping("couponSearch.mdo")
	public String couponSearch(Model model,  CouponVO couponVO,
								@RequestParam(value = "searchOption") String searchOption,
								@RequestParam(value = "keyword") String keyword) {
		if (searchOption.equals("coupon_name")) {
			couponVO.setKeyword(keyword);
			
			List<CouponVO> couponList = couponService.nameSearch(couponVO);
			model.addAttribute("couponList", couponList);
			PagingVO pagingVO = new PagingVO();
			return "/admin/coupon/couponList";
		}
		return null;
	}

	

	@RequestMapping("insertCouponPro.mdo")
	public String insertCoupon(CouponVO couponVO, @RequestParam(value = "first") String first,
			@RequestParam(value = "last") String last) throws Exception {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmm");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmm");

		Date coupon_first = sdf1.parse(first);
		couponVO.setCoupon_first(coupon_first);

		Date coupon_last = sdf2.parse(last);
		couponVO.setCoupon_last(coupon_last);


		couponService.insertCoupon(couponVO);
		return "redirect:getCouponList.mdo";
	}
	
	@RequestMapping("deleteCoupon.mdo")
	public String deleteCoupon(CouponVO couponVO,@RequestParam(value="coupon_no")Long coupon_no) {
		couponVO.setCoupon_no(coupon_no);
		
		couponService.deleteCoupon(couponVO);
		return "redirect:getCouponList.mdo";
	}
	
	@RequestMapping("viewCoupon.mdo")
	public String viewCoupon(Model model, @RequestParam(value = "coupon_no") int coupon_no, CouponVO couponVO) {
		CouponVO viewCoupon = couponService.viewCoupon(couponVO);

		model.addAttribute("article", viewCoupon);
		return "/admin/coupon/viewCoupon";
	}
	
	@RequestMapping("updateCouponGate.mdo")
	public String updateGate(@RequestParam(value="board_no")Long board_no) {
		return "redirect:updateArticle.mdo?board_no="+board_no;
	}
	
	@RequestMapping("updateCoupon.mdo")
	public String updateCoupon(Model model, @RequestParam(value="coupon_no")int coupon_no, CouponVO couponVO) {
		CouponVO updateCoupon = couponService.viewCoupon(couponVO);
		
		model.addAttribute("article", updateCoupon);
		return "/admin/coupon/updateCoupon";
	}
	
	@RequestMapping("updateCouponPro.mdo")
	public String updateCouponPro(@RequestParam("coupon_name")String coupon_name,@RequestParam("coupon_price")Long coupon_price,@RequestParam("coupon_no")Long coupon_no, @RequestParam(value="coupon_first")String first, @RequestParam(value="coupon_last")String last)throws Exception{
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
		
		Date coupon_first = sdf1.parse(first);
		Date coupon_last = sdf2.parse(last);
		
		CouponVO couponVO = new CouponVO();
		
		couponVO.setCoupon_first(coupon_first);
		couponVO.setCoupon_last(coupon_last);
		
		couponService.updateCoupon(couponVO);
		return "redirect:getCouponList.mdo";
	}

}// end class

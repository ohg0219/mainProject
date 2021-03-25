package com.thisisthat.admin.grant.coupon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.admin.coupon.vo.CouponVO;
import com.thisisthat.admin.grant.coupon.service.CouponGrantService;
import com.thisisthat.admin.grant.coupon.vo.CouponGrantVO;
import com.thisisthat.admin.usermanagement.vo.UserVO;

@Controller
@RequestMapping("/admin/*")
public class GrantCouponController {

	@Autowired
	private CouponGrantService couponGrantService;
	
	
	@RequestMapping("grantCoupon.mdo")
	public String grantCouponList(Model model, CouponGrantVO vo, UserVO vo1) {
		List<CouponGrantVO> userCouponList = couponGrantService.userCouponList(vo);
		model.addAttribute("userCouponList", userCouponList);
		return "/admin/coupon/grantCoupon";
	}
	/**
	 * 고객에게 쿠폰 부여 페이지로 이동
	 * @return
	 */
	@GetMapping("userGrant.mdo")
	public String userGrant(Model model, UserVO vo, CouponVO vo1) {
		List<UserVO> userIdList = couponGrantService.getUserIDList(vo);
		model.addAttribute("userIdList", userIdList);
		List<CouponVO> selectCoupon = couponGrantService.getAdminCoupon(vo1);
		model.addAttribute("selectCoupon", selectCoupon);
		return "/admin/coupon/userGrant";
	}
	
	/**
	 * 관리자 페이지에서 
	 * 고객에게 쿠폰 부여 
	 * 실행 누르면 데이터 베이스에 부여가 된다.
	 * @return
	 */
	@RequestMapping("userGrant.mdo")
	public String couponGrant(@RequestParam(value = "userId") String userId,
								@RequestParam(value="coupon")int coupon,
								CouponGrantVO vo , UserVO vo1) {
		if(userId.equals("all")) {
			List<UserVO> userIdList=couponGrantService.getUserIDList(vo1);
			couponGrantService.userAllGrantCoupon(userIdList, coupon);
		}else {
			vo.setUser_id(userId);
			vo.setCoupon_no(coupon);
			couponGrantService.userGrantCoupon(vo);
		}
		
		
		return  "redirect:/grantCoupon.mdo";
	}
	
	
	
}

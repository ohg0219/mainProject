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
import com.thisisthat.util.PagingVO;

@Controller
@RequestMapping("/admin/*")
public class GrantCouponController {

	@Autowired
	private CouponGrantService couponGrantService;
	
	
	@RequestMapping("mainGo.mdo")
	public String mainGo() {
		return "/admin/main.mdo";
	}
	
	
	/*
	 * 관리자 페이지에서 쿠폰 부여 페이지를 요청 했을때 가는 요청 메서드
	 * 쿠폰 부여 현황 페이지가 보여짐
	 */
	@RequestMapping("grantCoupon.mdo")
	public String grantCouponList(Model model,
			@RequestParam(value = "keyword", required = false, defaultValue = "")String keyword,
			@RequestParam(value = "searchOption", required = false, defaultValue = "all")String searchOption,
			@RequestParam(value = "nowPage", required = false)Integer nowPage,
			CouponGrantVO vo) {
		if(nowPage == null) nowPage = 1;
		System.out.println(keyword);
		System.out.println(searchOption);
		PagingVO paging = new PagingVO(couponGrantService.couponCount(searchOption, keyword), nowPage, 15);
											//이것이 토탈 페이지 ↑
		model.addAttribute("userCouponList", couponGrantService.userCouponList(paging, searchOption, keyword));
		model.addAttribute("keyword", keyword);
		model.addAttribute("searchOption",searchOption);
		model.addAttribute("paging",paging);
		return "/admin/coupon/grantCoupon";
		
	}
	/**
	 * 고객에게 쿠폰 부여 페이지로 이동
	 * 쿠폰 부여 페이지로가는 요청
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
		return  "redirect:/admin/grantCoupon.mdo";
	}
	
	
	/**
	 * 관리자 페이지에서 
	 * 부여된 쿠폰 이름을 클릭하면 쿠폰의 정보가
	 * 뜨게 만드는 메서드
	 */
	@GetMapping("grantCouponView.mdo")
	public String grantCouponView(Model model, @RequestParam(value = "coupon_no") long coupon_no, CouponVO vo) {
		
		vo.setCoupon_no(coupon_no);
		CouponVO grantVo = couponGrantService.getAdminCouponInfo(vo);
		
		model.addAttribute("grantVo", grantVo);
		return "/admin/coupon/userCouponInfo";
	}
	
	
	//부여 쿠폰 현황에서 아이디를 누르면 그 아이디를 가진 회원의 쿠폰 리스트가 나오는 메서드
	@GetMapping("couponUserList.mdo")
	public String CouponUserList(Model model, @RequestParam(value = "user_id") String user_id, CouponGrantVO vo) {
		vo.setUser_id(user_id);
		List<CouponGrantVO> couponUserList = couponGrantService.couponUserList(vo);
		model.addAttribute("couponUserList", couponUserList);
		model.addAttribute("user_Id", user_id);
		return "/admin/coupon/userCouponView";
	}
	
	
	
	//회원의 쿠폰 List에서 쿠폰선택 삭제를 할 수 있는 메서드
	@RequestMapping("userCouponDeleteSel.mdo")
	public String userCouponDeleteSel(@RequestParam("coupon_no") int coupon_no,
			@RequestParam("user_id") String user_id,
			CouponGrantVO vo) {

		System.out.println(user_id);
		vo.setUser_id(user_id);
		vo.setCoupon_no(coupon_no);
		couponGrantService.userCouponDeleteSel(vo);
		return "redirect:couponUserList.mdo?user_id="+user_id;
	}
	
	
	//한 회원이 가진 쿠폰 전체를 삭제 할 수 있는 메서드
	@RequestMapping("userCouponDeleteAll.mdo")
	public String userCouponDeleteAll(@RequestParam("user_id") String user_id,
			CouponGrantVO vo) {
		vo.setUser_id(user_id);
		couponGrantService.userCouponDeleteAll(vo);
		return "redirect:grantCoupon.mdo";
	}
	
	
}

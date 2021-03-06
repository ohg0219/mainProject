package com.thisisthat.admin.grant.coupon.service;

import java.util.List;

import com.thisisthat.admin.coupon.vo.CouponVO;
import com.thisisthat.admin.grant.coupon.vo.CouponGrantVO;
import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.util.PagingVO;

public interface CouponGrantService {
	
	public List<UserVO> getUserIDList(UserVO vo);
	
	public List<CouponVO> getAdminCoupon(CouponVO vo);
	
	public void userGrantCoupon(CouponGrantVO vo);
	
	public void userAllGrantCoupon(List<UserVO> userIdList, int coupon);
	
	public List<CouponGrantVO> userCouponList(PagingVO paging, String searchOption, String keyword);
	
	int couponCount(String searchOption, String keyword);
	
	public CouponVO getAdminCouponInfo(CouponVO vo);
	
	
	//회원 쿠폰 부여 현황에서 아이디 누르면 아이디의 쿠폰 목록이 나오는 메서드
	public List<CouponGrantVO> couponUserList(CouponGrantVO vo);
	
	public String userIdCoupon(String userId);
	
	
//	//회원 쿠폰 부여 현황에서 검색하는 메서드 
//	public List<CouponGrantVO> nameCouponSearch(CouponGrantVO vo);
//	
//	public List<CouponGrantVO> IdCouponSearch(CouponGrantVO vo);
	
	
	//개별 삭제 메서드 
	public void userCouponDeleteSel(CouponGrantVO vo);
	//전체 삭제 메서드
	public void userCouponDeleteAll(CouponGrantVO vo);
}

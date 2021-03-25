package com.thisisthat.admin.grant.coupon.service;

import java.util.List;

import com.thisisthat.admin.coupon.vo.CouponVO;
import com.thisisthat.admin.grant.coupon.vo.CouponGrantVO;
import com.thisisthat.admin.usermanagement.vo.UserVO;

public interface CouponGrantService {
	
	public List<UserVO> getUserIDList(UserVO vo);
	
	public List<CouponVO> getAdminCoupon(CouponVO vo);
	
	public void userGrantCoupon(CouponGrantVO vo);
	
	public void userAllGrantCoupon(List<UserVO> userIdList, int coupon);
	
	public List<CouponGrantVO> userCouponList(CouponGrantVO vo);
}

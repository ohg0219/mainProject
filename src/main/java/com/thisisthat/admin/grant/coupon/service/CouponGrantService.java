package com.thisisthat.admin.grant.coupon.service;

import java.util.List;

import com.thisisthat.admin.grant.coupon.vo.CouponGrantVO;

public interface CouponGrantService {
	
	public List<CouponGrantVO> getUserIDList(CouponGrantVO vo);
	
	public List<CouponGrantVO> getAdminCoupon(CouponGrantVO vo);
	
	public void userGrantCoupon(CouponGrantVO vo);
}

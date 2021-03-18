package com.thisisthat.admin.coupon.service;

import java.util.List;

import com.thisisthat.admin.coupon.vo.CouponVO;

public interface CouponService {

	List<CouponVO> couponList(CouponVO couponVO);

	List<CouponVO> nameSearch(CouponVO couponVO);

	CouponVO viewCoupon(CouponVO couponVO);

	void insertCoupon(CouponVO couponVO);

	
		
	
	

	

}

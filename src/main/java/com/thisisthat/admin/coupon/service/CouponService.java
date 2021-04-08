package com.thisisthat.admin.coupon.service;

import java.util.List;
import java.util.Map;

import com.thisisthat.admin.coupon.vo.CouponVO;

public interface CouponService {

	List<CouponVO> couponList(Map<String, Object> map);

	CouponVO viewCoupon(CouponVO couponVO);

	void insertCoupon(CouponVO couponVO);

	void deleteCoupon(CouponVO couponVO);

	void updateCoupon(CouponVO couponVO);

	int couponCount(CouponVO couponVO);

		
	
	

	

}

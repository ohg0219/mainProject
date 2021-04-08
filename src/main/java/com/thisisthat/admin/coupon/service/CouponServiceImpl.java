package com.thisisthat.admin.coupon.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.coupon.DAO.CouponDAO;
import com.thisisthat.admin.coupon.vo.CouponVO;

@Service
public class CouponServiceImpl implements CouponService {
	
	@Autowired
	CouponDAO couponDAO;

	@Override
	public List<CouponVO> couponList(Map<String, Object> map) {

		return couponDAO.couponList(map);
	}

	@Override
	public CouponVO viewCoupon(CouponVO couponVO) {
		return couponDAO.viewCoupon(couponVO);
	}

	@Override
	public void insertCoupon(CouponVO couponVO) {
		couponDAO.insertCoupon(couponVO);
	}

	@Override
	public void deleteCoupon(CouponVO couponVO) {
		couponDAO.deleteCoupon(couponVO);
	}

	@Override
	public void updateCoupon(CouponVO couponVO) {
		couponDAO.updateCoupon(couponVO);
	}

	@Override
	public int couponCount(CouponVO couponVO) {
		return couponDAO.getCouponCount(couponVO);
	}

}

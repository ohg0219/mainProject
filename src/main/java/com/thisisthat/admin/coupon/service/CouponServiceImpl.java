package com.thisisthat.admin.coupon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.coupon.dao.CouponDAO;
import com.thisisthat.admin.coupon.vo.CouponVO;

@Service("CouponService")
public class CouponServiceImpl implements CouponService {

	@Autowired
	CouponDAO couponDAO;

	@Override
	public List<CouponVO> couponList(CouponVO couponVO) {

		return couponDAO.couponList(couponVO);
	}

	@Override
	public List<CouponVO> nameSearch(CouponVO couponVO) {
		return couponDAO.nameSearch(couponVO);
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

}

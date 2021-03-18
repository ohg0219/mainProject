package com.thisisthat.admin.coupon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.coupon.DAO.CouponDAO;
import com.thisisthat.admin.coupon.vo.CouponVO;

@Service("CouponService")
public class CouponServiceImpl implements CouponService{
	
	@Autowired
	CouponDAO couponDAO;

	@Override
	public List<CouponVO> couponList(CouponVO couponVO) {
		
		return couponDAO.couponList(couponVO);
	}

}

package com.thisisthat.user.coupon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.user.coupon.dao.UserCouponDAO;
import com.thisisthat.user.coupon.vo.UserCouponVO;
import com.thisisthat.util.PagingVO;

@Service
public class UserCouponServiceImpl implements UserCouponService {

	@Autowired
	private UserCouponDAO couponDAO;
	
	@Override
	public List<UserCouponVO> getCouponList(String userId,PagingVO pagingVO) {
		return couponDAO.getCouponList(userId,pagingVO);
	}

	@Override
	public int getCouponCount(String userId) {
		return couponDAO.getCouponCount(userId);
	}

	
}

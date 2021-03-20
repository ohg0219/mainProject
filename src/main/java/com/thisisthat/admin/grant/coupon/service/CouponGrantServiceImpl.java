package com.thisisthat.admin.grant.coupon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.grant.coupon.dao.UserCouponDAO;
import com.thisisthat.admin.grant.coupon.vo.CouponGrantVO;


@Service

public class CouponGrantServiceImpl implements CouponGrantService {

	@Autowired
	private UserCouponDAO couponGrantDAO;
	
	
	@Override
	public List<CouponGrantVO> getUserIDList(CouponGrantVO vo) {
		return couponGrantDAO.getUserIDList(vo);
	}

	@Override
	public List<CouponGrantVO> getAdminCoupon(CouponGrantVO vo) {
		return couponGrantDAO.getAdminCoupon(vo);
	}

	@Override
	public void userGrantCoupon(CouponGrantVO vo) {
		couponGrantDAO.userGrantCoupon(vo);
	}

	
}

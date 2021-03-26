package com.thisisthat.admin.grant.coupon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.coupon.vo.CouponVO;
import com.thisisthat.admin.grant.coupon.dao.UserCouponDAO;
import com.thisisthat.admin.grant.coupon.vo.CouponGrantVO;
import com.thisisthat.admin.usermanagement.vo.UserVO;


@Service

public class CouponGrantServiceImpl implements CouponGrantService {

	@Autowired
	private UserCouponDAO couponGrantDAO;
	
	
	@Override
	public List<UserVO> getUserIDList(UserVO vo) {
		return couponGrantDAO.getUserIDList(vo);
	}

	@Override
	public List<CouponVO> getAdminCoupon(CouponVO vo) {
		return couponGrantDAO.getAdminCoupon(vo);
	}

	@Override
	public void userGrantCoupon(CouponGrantVO vo) {
		couponGrantDAO.userGrantCoupon(vo);
	}

	@Override
	public List<CouponGrantVO> userCouponList(CouponGrantVO vo) {
		return couponGrantDAO.userCouponList(vo);
	}

	@Override
	public void userAllGrantCoupon(List<UserVO> userIdList, int coupon) {
		couponGrantDAO.userAllGrantCoupon(userIdList, coupon);
	}

	@Override
	public CouponVO getAdminCouponInfo(CouponVO vo) {
		return couponGrantDAO.getAdminCouponInfo(vo);
	}

	@Override
	public List<CouponGrantVO> couponUserList(CouponGrantVO vo) {
		return couponGrantDAO.couponUserList(vo);
	}

	@Override
	public String userIdCoupon(String userId) {
		return couponGrantDAO.userIdCoupon(userId);
	}

	@Override
	public List<CouponGrantVO> nameCouponSearch(CouponGrantVO vo) {
		return couponGrantDAO.nameCouponSearch(vo);
	}

	@Override
	public List<CouponGrantVO> IdCouponSearch(CouponGrantVO vo) {
		return couponGrantDAO.IdCouponSearch(vo);
	}
	
}

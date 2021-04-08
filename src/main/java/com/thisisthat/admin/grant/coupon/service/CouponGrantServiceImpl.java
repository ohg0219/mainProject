package com.thisisthat.admin.grant.coupon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.coupon.vo.CouponVO;
import com.thisisthat.admin.grant.coupon.dao.UserCouponDAO;
import com.thisisthat.admin.grant.coupon.vo.CouponGrantVO;
import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.util.PagingVO;


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

//	@Override
//	public List<CouponGrantVO> nameCouponSearch(CouponGrantVO vo) {
//		return couponGrantDAO.nameCouponSearch(vo);
//	}
//
//	@Override
//	public List<CouponGrantVO> IdCouponSearch(CouponGrantVO vo) {
//		return couponGrantDAO.IdCouponSearch(vo);
//	}

	@Override
	public void userCouponDeleteSel(CouponGrantVO vo) {
		couponGrantDAO.userCouponDeleteSel(vo);
	}
	
	public void userCouponDeleteAll(CouponGrantVO vo) {
		couponGrantDAO.userCouponDeleteAll(vo);
	}
	@Override
	
	public List<CouponGrantVO> userCouponList(PagingVO paging, String searchOption, String keyword) {
		return couponGrantDAO.userCouponList(paging, searchOption, keyword);
	}

	@Override
	public int couponCount(String searchOption, String keyword) {
		return couponGrantDAO.couponCount( searchOption, keyword);
	}
}

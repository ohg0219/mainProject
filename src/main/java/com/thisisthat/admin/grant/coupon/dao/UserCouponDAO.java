package com.thisisthat.admin.grant.coupon.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.admin.grant.coupon.vo.CouponGrantVO;

@Repository
public class UserCouponDAO {

	@Autowired
	SqlSessionTemplate userCouponTemplate;
	
	public List<CouponGrantVO> getUserIDList(CouponGrantVO vo) {
		return userCouponTemplate.selectList("UserCouponDAO.getUserIDList", vo);
	}
	
	public List<CouponGrantVO> getAdminCoupon(CouponGrantVO vo){
		return userCouponTemplate.selectList("UserCouponDAO.getAdminCoupon", vo);
	}
	
	public void userGrantCoupon(CouponGrantVO vo) {
		userCouponTemplate.insert("UserCouponDAO.userGrantCoupon", vo);
	}
	
	
}

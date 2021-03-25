package com.thisisthat.admin.grant.coupon.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.admin.coupon.vo.CouponVO;
import com.thisisthat.admin.grant.coupon.vo.CouponGrantVO;
import com.thisisthat.admin.usermanagement.vo.UserVO;

@Repository
public class UserCouponDAO {

	@Autowired
	SqlSessionTemplate userCouponTemplate;
	
	public List<UserVO> getUserIDList(UserVO vo) {
		return userCouponTemplate.selectList("UserCouponDAO.getUserIDList", vo);
	}
	
	public List<CouponVO> getAdminCoupon(CouponVO vo){
		return userCouponTemplate.selectList("UserCouponDAO.getAdminCoupon", vo);
	}
	
	public void userGrantCoupon(CouponGrantVO vo) {
		userCouponTemplate.insert("UserCouponDAO.userGrantCoupon", vo);
	}
	
	public void userAllGrantCoupon(List<UserVO> userIdList, int coupon) {
		for(UserVO list : userIdList) {
			CouponGrantVO map = new CouponGrantVO();
			map.setUser_id(list.getUserId());
			map.setCoupon_no(coupon);
			userCouponTemplate.insert("UserCouponDAO.userGrantCoupon", map);
		}
	}
	
	public List<CouponGrantVO> userCouponList(CouponGrantVO vo) {
		return userCouponTemplate.selectList("UserCouponDAO.userCouponList", vo);
	}
	
}

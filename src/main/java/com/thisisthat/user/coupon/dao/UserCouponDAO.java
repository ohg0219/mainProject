package com.thisisthat.user.coupon.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.user.coupon.vo.UserCouponVO;
import com.thisisthat.util.PagingVO;

@Repository
public class UserCouponDAO {

	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public List<UserCouponVO> getCouponList(String userId,PagingVO pagingVO){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("start", pagingVO.getStart());
		return sessionTemplate.selectList("couponDAO.getCouponList",map);
	}
	
	public int getCouponCount(String userId) {
		return sessionTemplate.selectOne("couponDAO.getCouponCount",userId);
	}
	
}

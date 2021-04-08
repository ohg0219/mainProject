package com.thisisthat.admin.coupon.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.admin.coupon.vo.CouponVO;

@Repository
public class CouponDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	public List<CouponVO> couponList(Map<String, Object> map) {
		return mybatis.selectList("CouponDAO.couponList", map);
	}

	public CouponVO viewCoupon(CouponVO couponVO) {
		return mybatis.selectOne("CouponDAO.viewCoupon", couponVO);
	}

	public void insertCoupon(CouponVO couponVO) {
		 mybatis.insert("CouponDAO.insertCoupon", couponVO);
	}

	public void deleteCoupon(CouponVO couponVO) {
		mybatis.delete("CouponDAO.deleteCoupon", couponVO);		
	}

	public void updateCoupon(CouponVO couponVO) {
		mybatis.update("CouponDAO.updateCoupon", couponVO);
	}

	public int getCouponCount(CouponVO couponVO) {
		return mybatis.selectOne("CouponDAO.couponCount", couponVO);
	}
	
	
	
	
	
}

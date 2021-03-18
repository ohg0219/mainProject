package com.thisisthat.admin.coupon.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.admin.coupon.vo.CouponVO;

@Repository
public class CouponDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	public List<CouponVO> couponList(CouponVO couponVO) {
		return mybatis.selectList("CouponDAO.couponList",couponVO);
	}

	public List<CouponVO> nameSearch(CouponVO couponVO) {
		return mybatis.selectList("CouponDAO.nameSearch", couponVO);
	}

	public CouponVO viewCoupon(CouponVO couponVO) {
		return mybatis.selectOne("CouponDAO.viewCoupon", couponVO);
	}

	public void insertCoupon(CouponVO couponVO) {
		 mybatis.insert("CouponDAO.insertCoupon", couponVO);
	}

}

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

}

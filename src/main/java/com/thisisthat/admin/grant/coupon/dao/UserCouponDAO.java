package com.thisisthat.admin.grant.coupon.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.admin.coupon.vo.CouponVO;
import com.thisisthat.admin.grant.coupon.vo.CouponGrantVO;
import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.user.controller.UserController;

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
			//여기서 userId와 coupon_no의 값을 가지고 있는  그릇 CouponGrantVO라는 지역변수를 선언해준것
			//여기서 안쓰면 mybatismapper파일에서 foreach를 써주어야한다 dao에서 해주는게 편하다
			CouponGrantVO map = new CouponGrantVO();
			map.setUser_id(list.getUserId());
			map.setCoupon_no(coupon);
			userCouponTemplate.insert("UserCouponDAO.userGrantCoupon", map);
		}
	}
	
	public List<CouponGrantVO> userCouponList(CouponGrantVO vo) {
		return userCouponTemplate.selectList("UserCouponDAO.userCouponList", vo);
	}
	
	public CouponVO getAdminCouponInfo(CouponVO vo) {
		return (CouponVO) userCouponTemplate.selectOne("UserCouponDAO.getAdminCouponInfo", vo);
	}
	
	//쿠폰 부여 현황에서 아이디를 클릭하면 회원이 가진 쿠폰 리스트를 보여주는 메서드
	public List<CouponGrantVO> couponUserList(CouponGrantVO vo) {
		return userCouponTemplate.selectList("UserCouponDAO.couponUserList", vo);
	}
	
	public String userIdCoupon(String userId) {
		return userCouponTemplate.selectOne("UserCouponDAO.userIdCoupon", userId);
	}
	
	public List<CouponGrantVO> nameCouponSearch(CouponGrantVO vo){
		return userCouponTemplate.selectList("UserCouponDAO.nameCouponSearch", vo);
	}
	
	public List<CouponGrantVO> IdCouponSearch(CouponGrantVO vo){
		return userCouponTemplate.selectList("UserCouponDAO.IdCouponSearch", vo);
	}
	
}

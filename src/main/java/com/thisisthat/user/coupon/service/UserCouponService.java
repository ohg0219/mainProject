package com.thisisthat.user.coupon.service;

import java.util.List;

import com.thisisthat.user.coupon.vo.UserCouponVO;
import com.thisisthat.util.PagingVO;

public interface UserCouponService {

	List<UserCouponVO> getCouponList(String userId,PagingVO pagingVO);
	int getCouponCount(String userId);
}

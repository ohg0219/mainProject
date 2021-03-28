package com.thisisthat.user.payment.service;

import java.util.Date;
import java.util.List;

import com.thisisthat.user.payment.vo.UserBasketVO;
import com.thisisthat.user.payment.vo.UserPaymentVO;
import com.thisisthat.user.payment.vo.UserVO;

public interface UserPaymentService {

	UserVO getUserInfo(String userId);
	int getUserBasketPrice(String userId);
	int getUserPoint(String userId);
	int basketPointSum(String userId);
	int insertOrder(UserPaymentVO vo);
	List<UserBasketVO> getBasketList(String userId);
	Date getOrderDate(int orderNo);
	void insertUsePoint(UserPaymentVO vo);
}
package com.thisisthat.user.payment.service;

import java.util.Date;
import java.util.List;

import com.thisisthat.user.basket.vo.UserBasketItemVO;
import com.thisisthat.user.payment.vo.UserAddressVO;
import com.thisisthat.user.payment.vo.UserBasketVO;
import com.thisisthat.user.payment.vo.UserCouponVO;
import com.thisisthat.user.payment.vo.UserMailVO;
import com.thisisthat.user.payment.vo.UserPaymentVO;
import com.thisisthat.user.payment.vo.UserVO;

public interface UserPaymentService {

	UserVO getUserInfo(String userId);
	int getUserBasketPrice(String userId);
	int getUserPoint(String userId);
	List<UserCouponVO> getCouponList(String userId);
	void updateCoupon(UserPaymentVO vo);
	int basketPointSum(String userId);
	int insertOrder(UserPaymentVO vo);
	int insertNonMemberOrder(UserPaymentVO vo,List<UserBasketItemVO> sessionBasket);
	List<UserBasketVO> getBasketList(String userId);
	Date getOrderDate(int orderNo);
	void insertUsePoint(UserPaymentVO vo);
	List<UserMailVO> userOrderInfo(int orderNo);
	UserPaymentVO userOrder(int orderNo);
	boolean userBasketOrderCount(String userId);
	boolean nonMemberBasketOrderCount(List<UserBasketItemVO> basketItem);
	List<UserAddressVO> getUserAddressList(String userId);
}

package com.thisisthat.user.payment.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.user.basket.vo.UserBasketItemVO;
import com.thisisthat.user.payment.dao.UserPaymentDAO;
import com.thisisthat.user.payment.vo.UserBasketVO;
import com.thisisthat.user.payment.vo.UserMailVO;
import com.thisisthat.user.payment.vo.UserPaymentVO;
import com.thisisthat.user.payment.vo.UserVO;

@Service
public class UserPaymentServiceImpl implements UserPaymentService {

	@Autowired
	public UserPaymentDAO paymentDAO;

	@Override
	public UserVO getUserInfo(String userId) {
		return paymentDAO.getUserInfo(userId);
	}

	@Override
	public int getUserBasketPrice(String userId) {
		return paymentDAO.getUserBasketPrice(userId);
	}

	@Override
	public int getUserPoint(String userId) {
		return paymentDAO.getUserPoint(userId);
	}

	@Override
	public int basketPointSum(String userId) {
		return paymentDAO.basketPointSum(userId);
	}

	@Override
	public int insertOrder(UserPaymentVO vo) {
		return paymentDAO.insertOrder(vo);
	}

	@Override
	public List<UserBasketVO> getBasketList(String userId) {
		return paymentDAO.getBasketList(userId);
	}

	@Override
	public Date getOrderDate(int orderNo) {
		return paymentDAO.getOrderDate(orderNo);
	}

	@Override
	public void insertUsePoint(UserPaymentVO vo) {
		paymentDAO.insertUsePoint(vo);
	}

	@Override
	public int insertNonMemberOrder(UserPaymentVO vo, List<UserBasketItemVO> sessionBasket) {
		return paymentDAO.insertNonMemberOrder(vo, sessionBasket);
	}

	@Override
	public List<UserMailVO> userOrderInfo(int orderNo) {
		return paymentDAO.userOrderInfo(orderNo);
	}

	@Override
	public UserPaymentVO userOrder(int orderNo) {
		return paymentDAO.userOrder(orderNo);
	}
	
	
}

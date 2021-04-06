package com.thisisthat.user.payment.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.thisisthat.user.basket.vo.UserBasketItemVO;
import com.thisisthat.user.payment.vo.UserAddressVO;
import com.thisisthat.user.payment.vo.UserBasketVO;
import com.thisisthat.user.payment.vo.UserMailVO;
import com.thisisthat.user.payment.vo.UserOrderVO;
import com.thisisthat.user.payment.vo.UserPaymentVO;
import com.thisisthat.user.payment.vo.UserVO;


@Controller
public class UserPaymentDAO {

	@Autowired
	public SqlSessionTemplate paymentTemplate;
	
	public UserVO getUserInfo(String userId) {
		return paymentTemplate.selectOne("PaymentDAO.getUserInfo", userId);
	}
	public int getUserBasketPrice(String userId) {
		return paymentTemplate.selectOne("PaymentDAO.getUserBasketPrice",userId);
	}
	public int getUserPoint(String userId) {
		return paymentTemplate.selectOne("PaymentDAO.getUserPoint",userId);
	}
	public int basketPointSum(String userId) {
		return paymentTemplate.selectOne("PaymentDAO.basketPointSum",userId);
	}
	@Transactional
	public int insertOrder(UserPaymentVO vo) {
		paymentTemplate.insert("PaymentDAO.insertOrder",vo);
		int seq = paymentTemplate.selectOne("PaymentDAO.getSeq");
		List<UserBasketVO> basketList = paymentTemplate.selectList("PaymentDAO.getBasketList",vo.getUserId());
		for(UserBasketVO basket : basketList) { 
			UserOrderVO orderVO = new UserOrderVO(seq,basket.getProductNo(),basket.getSelectSize(),basket.getProductPrice(),basket.getSelectCount());
			paymentTemplate.insert("PaymentDAO.insertOrderProduct",orderVO);
			paymentTemplate.update("PaymentDAO.updateProductStock",basket);
		}
		String userId = vo.getUserId();
		paymentTemplate.delete("PaymentDAO.deleteBasket",userId);
		return seq;
	}
	public List<UserBasketVO> getBasketList(String userId){
		return paymentTemplate.selectList("PaymentDAO.getBasketList",userId);
	}
	
	public Date getOrderDate(int orderNo) {
		return paymentTemplate.selectOne("PaymentDAO.orderTime",orderNo);
	}
	
	public void insertUsePoint(UserPaymentVO vo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", vo.getUserId());
		map.put("usePoint", vo.getUsePoint()*-1);
		map.put("pointContent", "구매에 포인트 사용");
		paymentTemplate.insert("PaymentDAO.insertUsePoint",map);
	}
	
	public int insertNonMemberOrder(UserPaymentVO vo,List<com.thisisthat.user.basket.vo.UserBasketItemVO> sessionBasket) {
		paymentTemplate.insert("PaymentDAO.insertOrder",vo);
		int seq = paymentTemplate.selectOne("PaymentDAO.getSeq");
		for(UserBasketItemVO basket : sessionBasket) {
			UserOrderVO orderVO = new UserOrderVO(seq,basket.getProductNo(),basket.getSelectSize(),basket.getProductPrice(),basket.getSelectCount());
			paymentTemplate.insert("PaymentDAO.insertOrderProduct",orderVO);
			paymentTemplate.update("PaymentDAO.updateProductStock",basket);
		}
		return seq;
	}
	
	public List<UserMailVO> userOrderInfo(int orderNo){
		return paymentTemplate.selectList("PaymentDAO.userOrderInfo",orderNo);
	}
	
	public UserPaymentVO userOrder(int orderNo) {
		return paymentTemplate.selectOne("PaymentDAO.userOrder",orderNo);
	}
	
	public boolean userBasketOrderCount(String userId) {
		boolean flag = true;
		List<UserBasketVO> basketList = paymentTemplate.selectList("PaymentDAO.getBasketList",userId);
		for(UserBasketVO basket : basketList) {
			int stock = paymentTemplate.selectOne("PaymentDAO.getProductStock",basket);
			if(basket.getSelectCount()>stock) {
				flag = false;
			}
		}
		return flag;
	}
	public boolean nonMemberBasketOrderCount(List<UserBasketItemVO> basketItem) {
		boolean flag = true;
		for(UserBasketItemVO basket : basketItem) {
			int stock = paymentTemplate.selectOne("PaymentDAO.getProductStock",basket);
			if(basket.getSelectCount()>stock) {
				flag = false;
			}
		}
		return flag;
	}
	
	
	public List<UserAddressVO> getUserAddressList(String userId){
		return paymentTemplate.selectList("PaymentDAO.getUserAddressList",userId);
	}
	
	
}

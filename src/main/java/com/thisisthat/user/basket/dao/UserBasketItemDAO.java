package com.thisisthat.user.basket.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.user.basket.vo.UserBasketItemVO;

@Repository
public class UserBasketItemDAO {

	@Autowired
	SqlSessionTemplate sessionTemplate;
	
	public void insertBasket(List<UserBasketItemVO> basketItemList) {
		sessionTemplate.insert("BasketDAO.insertBasket",basketItemList);
	}
	
	public List<UserBasketItemVO> getBasketList(String userId){
		return sessionTemplate.selectList("BasketDAO.getBasketList",userId);
	}
	
	public UserBasketItemVO getItemInfo(long productNo) {
		return sessionTemplate.selectOne("BasketDAO.getItemInfo",productNo);
	}
}

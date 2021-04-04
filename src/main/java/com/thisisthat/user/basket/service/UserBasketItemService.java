package com.thisisthat.user.basket.service;

import java.util.List;

import com.thisisthat.user.basket.vo.UserBasketItemVO;

public interface UserBasketItemService {

	void insertBasket(List<UserBasketItemVO> basketItemList);
	List<UserBasketItemVO> getBasketList(String userId);
	UserBasketItemVO getItemInfo(long productNo);
	void deleteUserBasket(UserBasketItemVO vo);
	void updateUserBasket(UserBasketItemVO vo);
	boolean getProductStock(List<UserBasketItemVO> basketItemList);
}

package com.thisisthat.user.basket.service;

import java.util.List;

import com.thisisthat.user.basket.vo.UserBasketItemVO;

public interface UserBasketItemService {

	void insertBasket(List<UserBasketItemVO> basketItemList);
}

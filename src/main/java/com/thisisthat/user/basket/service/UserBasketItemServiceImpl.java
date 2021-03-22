package com.thisisthat.user.basket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.user.basket.dao.UserBasketItemDAO;
import com.thisisthat.user.basket.vo.UserBasketItemVO;

@Service
public class UserBasketItemServiceImpl implements UserBasketItemService {

	@Autowired
	UserBasketItemDAO basketItemDAO;
	
	@Override
	public void insertBasket(List<UserBasketItemVO> basketItemList) {
		basketItemDAO.insertBasket(basketItemList);
	}

}

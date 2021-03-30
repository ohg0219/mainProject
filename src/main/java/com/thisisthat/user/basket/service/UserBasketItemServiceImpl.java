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

	@Override
	public List<UserBasketItemVO> getBasketList(String userId) {
		return basketItemDAO.getBasketList(userId);
	}

	@Override
	public UserBasketItemVO getItemInfo(long productNo) {
		return basketItemDAO.getItemInfo(productNo);
	}

	@Override
	public void deleteUserBasket(UserBasketItemVO vo) {
		basketItemDAO.deleteUserBasket(vo);
	}

	@Override
	public void updateUserBasket(UserBasketItemVO vo) {
		basketItemDAO.updateUserBasket(vo);
	}

}

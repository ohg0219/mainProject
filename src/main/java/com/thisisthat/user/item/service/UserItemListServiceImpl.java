package com.thisisthat.user.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.user.item.dao.UserItemListDAO;
import com.thisisthat.user.item.vo.UserItemImageVO;
import com.thisisthat.user.item.vo.UserItemListVO;
import com.thisisthat.user.item.vo.UserItemSizeGuideVO;
import com.thisisthat.user.item.vo.UserItemSizeUsedVO;
import com.thisisthat.user.item.vo.UserItemVO;

@Service
public class UserItemListServiceImpl implements UserItemListService {

	@Autowired
	private UserItemListDAO itemListDAO;
	
	@Override
	public List<UserItemListVO> getItemList(String categoryName) {
		return itemListDAO.getItemList(categoryName);
	}

	@Override
	public UserItemVO getItemInfo(long productNo) {
		return itemListDAO.getItemInfo(productNo);
	}

	@Override
	public List<UserItemImageVO> getItemImage(long productNo) {
		return itemListDAO.getItemImage(productNo);
	}

	@Override
	public List<UserItemSizeGuideVO> getItemSizeGuide(long productNo) {
		return itemListDAO.getItemSizeGuide(productNo);
	}

	@Override
	public UserItemSizeUsedVO getItemSizeUsed(long productNo) {
		return itemListDAO.getItemSizeUsed(productNo);
	}

}

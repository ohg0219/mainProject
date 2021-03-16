package com.thisisthat.user.itemlist.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.user.itemlist.dao.UserItemListDAO;
import com.thisisthat.user.itemlist.vo.UserItemListVO;

@Service
public class UserItemListServiceImpl implements UserItemListService {

	@Autowired
	private UserItemListDAO itemListDAO;
	
	@Override
	public List<UserItemListVO> getItemList(String categoryName) {
		return itemListDAO.getItemList(categoryName);
	}

}

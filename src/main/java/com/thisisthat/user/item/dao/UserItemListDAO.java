package com.thisisthat.user.item.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.thisisthat.user.item.vo.UserItemImageVO;
import com.thisisthat.user.item.vo.UserItemListVO;
import com.thisisthat.user.item.vo.UserItemVO;

@Controller
public class UserItemListDAO {

	@Autowired
	private SqlSessionTemplate itemListTemplate;
	
	
	public List<UserItemListVO> getItemList(String categoryName){
		return itemListTemplate.selectList("ItemDAO.getItemList",categoryName);
	}
	
	public UserItemVO getItemInfo(long productNo) {
		return itemListTemplate.selectOne("ItemDAO.getItemInfo",productNo);
	}
	
	public List<UserItemImageVO> getItemImage(long productNo){
		return itemListTemplate.selectList("ItemDAO.getItemImage",productNo);
	}
}

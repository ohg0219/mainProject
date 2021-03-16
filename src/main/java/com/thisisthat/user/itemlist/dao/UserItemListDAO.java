package com.thisisthat.user.itemlist.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.thisisthat.user.itemlist.vo.UserItemListVO;

@Controller
public class UserItemListDAO {

	@Autowired
	private SqlSessionTemplate itemListTemplate;
	
	
	public List<UserItemListVO> getItemList(String categoryName){
		return itemListTemplate.selectList("ItemListDAO.getItemList",categoryName);
	}
	
	
}

package com.thisisthat.user.recent.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.user.recent.vo.DbBasketItemVO;
import com.thisisthat.user.recent.vo.RecentBasketVO;
import com.thisisthat.user.recent.vo.RecentViewVO;

@Repository
public class RecentViewDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public RecentViewVO recentItem(RecentViewVO vo) {
		return mybatis.selectOne("RecentViewDAO.getRecentList", vo);
	}
	
	public void recentBasket(RecentBasketVO vo) {
		mybatis.insert("RecentViewDAO.insertBasket", vo);
	}

	public List<DbBasketItemVO> RecentBasketItem(String userId) {
		return mybatis.selectList("RecentViewDAO.getBasketList", userId);
	}
	
	
}
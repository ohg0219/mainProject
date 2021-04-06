package com.thisisthat.user.recent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.user.recent.dao.RecentViewDAO;
import com.thisisthat.user.recent.vo.DbBasketItemVO;
import com.thisisthat.user.recent.vo.RecentBasketVO;
import com.thisisthat.user.recent.vo.RecentViewVO;

@Service
public class RecentViewServiceImpl implements RecentViewService {

	@Autowired
	private RecentViewDAO dao;
	
	@Override
	public RecentViewVO itemView(RecentViewVO vo) {
		return dao.recentItem(vo);
	}

	@Override
	public void insertBasket(RecentBasketVO vo) {
		dao.recentBasket(vo);
	}
	
	@Override
	public List<DbBasketItemVO> getRecentBasketList(String userId) {
		return dao.RecentBasketItem(userId);
	}
}

package com.thisisthat.user.recent.service;

import java.util.List;

import com.thisisthat.user.recent.vo.DbBasketItemVO;
import com.thisisthat.user.recent.vo.RecentBasketVO;
import com.thisisthat.user.recent.vo.RecentViewVO;

public interface RecentViewService {

	RecentViewVO itemView(RecentViewVO vo);
	void insertBasket(RecentBasketVO vo);
	List<DbBasketItemVO> getRecentBasketList(String userId);
}
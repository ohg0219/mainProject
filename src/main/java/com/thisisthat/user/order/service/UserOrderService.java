package com.thisisthat.user.order.service;

import java.util.List;

import com.thisisthat.user.order.vo.UserOrderVO;
import com.thisisthat.util.PagingVO;

public interface UserOrderService {

	List<UserOrderVO> getOrderList(UserOrderVO vo,PagingVO pagingVO);
	List<UserOrderVO> getOrder(int orderNo);
	String getPassword(int orderNo);
	void updateState(int orderNo,String state);
	int getOrderCount(UserOrderVO vo);
}

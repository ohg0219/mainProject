package com.thisisthat.user.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.user.order.dao.UserOrderDAO;
import com.thisisthat.user.order.vo.UserOrderVO;
import com.thisisthat.util.PagingVO;

@Service
public class UserOrderServiceImpl implements UserOrderService {

	@Autowired
	private UserOrderDAO orderDAO;
	
	@Override
	public List<UserOrderVO> getOrderList(UserOrderVO vo,PagingVO pagingVO) {
		return orderDAO.getOrderList(vo,pagingVO);
	}

	@Override
	public List<UserOrderVO> getOrder(int orderNo) {
		return orderDAO.getOrder(orderNo);
	}

	@Override
	public String getPassword(int orderNo) {
		return orderDAO.getPassword(orderNo);
	}

	@Override
	public void updateState(int orderNo, String state) {
		orderDAO.updateState(orderNo, state);
	}

	@Override
	public int getOrderCount(UserOrderVO vo) {
		return orderDAO.getOrderCount(vo);
	}

}

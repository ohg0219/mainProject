package com.thisisthat.admin.orderManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.orderManagement.dao.OrderManagementDAO;
import com.thisisthat.admin.orderManagement.vo.OrderManagementVO;
import com.thisisthat.util.PagingVO;


@Service
public class OrderManagementServiceImpl implements OrderManagementService {
	
	@Autowired
	private OrderManagementDAO orderManagementDAO;
	
	@Override
	public List<OrderManagementVO> orderList(OrderManagementVO orderManagementVO,String searchOption,String keyword,PagingVO pagingVO) {
		return orderManagementDAO.orderList(orderManagementVO,searchOption,keyword,pagingVO);
	}

	@Override
	public List<OrderManagementVO> getOrder(OrderManagementVO orderManagementVO) {
		return orderManagementDAO.getOrder(orderManagementVO);
	}

	@Override
	public Object selectOrder_start(OrderManagementVO orderManagementVO) {
		return orderManagementDAO.selectOrder_start(orderManagementVO);
	}

	@Override
	public Object selectOrder(OrderManagementVO orderManagementVO) {
		return orderManagementDAO.selectOrder(orderManagementVO);
	}

	@Override
	public int getOrderCount(String searchOption, String keyword) {
		return orderManagementDAO.getOrderCount(searchOption, keyword);
	}

	@Override
	public void insertPoint(String userId, int waitingPoint) {
		orderManagementDAO.insertPoint(userId, waitingPoint);
	}

	@Override
	public void deletePoint(String userId, int waitingPoint) {
		orderManagementDAO.deletePoint(userId, waitingPoint);
	}

	@Override
	public OrderManagementVO getOrderInfo(OrderManagementVO orderManagementVO) {
		return orderManagementDAO.getOrderInfo(orderManagementVO);
	}

	

}

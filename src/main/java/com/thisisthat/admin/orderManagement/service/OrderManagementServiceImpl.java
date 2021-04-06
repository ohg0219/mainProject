package com.thisisthat.admin.orderManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.orderManagement.dao.OrderManagementDAO;
import com.thisisthat.admin.orderManagement.vo.OrderManagementVO;


@Service
public class OrderManagementServiceImpl implements OrderManagementService {
	
	@Autowired
	private OrderManagementDAO orderManagementDAO;
	
	@Override
	public List<OrderManagementVO> orderList(OrderManagementVO orderManagementVO) {
		return orderManagementDAO.orderList(orderManagementVO);
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
	public List<OrderManagementVO> allSearch(OrderManagementVO orderManagementVO) {
		return orderManagementDAO.allSearch(orderManagementVO);
	}

	@Override
	public List<OrderManagementVO> ordernoSearch(OrderManagementVO orderManagementVO) {
		return orderManagementDAO.ordernoSearch(orderManagementVO);
	}

	@Override
	public List<OrderManagementVO> useridSearch(OrderManagementVO orderManagementVO) {
		return orderManagementDAO.useridSearch(orderManagementVO);
	}

	@Override
	public List<OrderManagementVO> invoicenoSearch(OrderManagementVO orderManagementVO) {
		return orderManagementDAO.invoicenoSearch(orderManagementVO);
	}


	
}
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

}

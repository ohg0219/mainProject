package com.thisisthat.admin.orderManagement.service;

import java.util.List;

import com.thisisthat.admin.orderManagement.vo.OrderManagementVO;

public interface OrderManagementService {

	List<OrderManagementVO> orderList(OrderManagementVO orderManagementVO);

	List<OrderManagementVO> getOrder(OrderManagementVO orderManagementVO);

	Object selectOrder_start(OrderManagementVO orderManagementVO);

	Object selectOrder(OrderManagementVO orderManagementVO);



}

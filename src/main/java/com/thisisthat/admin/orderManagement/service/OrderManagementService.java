package com.thisisthat.admin.orderManagement.service;

import java.util.List;

import com.thisisthat.admin.orderManagement.vo.OrderManagementVO;
import com.thisisthat.util.PagingVO;

public interface OrderManagementService {

	int getOrderCount(String searchOption,String keyword);
	List<OrderManagementVO> orderList(OrderManagementVO orderManagementVO,String searchOption,String keyword,PagingVO pagingVO);

	OrderManagementVO getOrder(OrderManagementVO orderManagementVO);
	void insertPoint(String userId,int waitingPoint);
	void deletePoint(String userId,int waitingPoint);
	Object selectOrder_start(OrderManagementVO orderManagementVO);

	Object selectOrder(OrderManagementVO orderManagementVO);




}

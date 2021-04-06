package com.thisisthat.admin.orderManagement.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.admin.orderManagement.vo.OrderManagementVO;

@Repository
public class OrderManagementDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<OrderManagementVO> orderList(OrderManagementVO orderManagementVO) {
		return mybatis.selectList("orderManagementDAO.orderList", orderManagementVO);
	}

	public List<OrderManagementVO> getOrder(OrderManagementVO orderManagementVO) {
		return mybatis.selectList("orderManagementDAO.getOrder", orderManagementVO);
	}

	public Object selectOrder_start(OrderManagementVO orderManagementVO) {
		return mybatis.update("orderManagementDAO.selectOrder_start", orderManagementVO);
	}

	public Object selectOrder(OrderManagementVO orderManagementVO) {
		return mybatis.update("orderManagementDAO.selectOrder", orderManagementVO);
	}

	public List<OrderManagementVO> allSearch(OrderManagementVO orderManagementVO) {
		return mybatis.selectList("orderManagementDAO.allSearch", orderManagementVO);
	}

	public List<OrderManagementVO> ordernoSearch(OrderManagementVO orderManagementVO) {
		return mybatis.selectList("orderManagementDAO.ordernoSearch", orderManagementVO);
	}

	public List<OrderManagementVO> useridSearch(OrderManagementVO orderManagementVO) {
		return mybatis.selectList("orderManagementDAO.useridSearch", orderManagementVO);
	}

	public List<OrderManagementVO> invoicenoSearch(OrderManagementVO orderManagementVO) {
		return mybatis.selectList("orderManagementDAO.invoicenoSearch", orderManagementVO);
	}

	
	

	

}
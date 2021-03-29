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

}

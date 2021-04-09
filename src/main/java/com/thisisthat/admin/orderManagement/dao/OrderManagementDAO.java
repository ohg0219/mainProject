package com.thisisthat.admin.orderManagement.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.admin.orderManagement.vo.OrderManagementVO;
import com.thisisthat.util.PagingVO;

@Repository
public class OrderManagementDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int getOrderCount(String searchOption, String keyword) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return mybatis.selectOne("orderManagementDAO.getOrderCount",map);
	}
	
	public List<OrderManagementVO> orderList(OrderManagementVO orderManagementVO,String searchOption,String keyword,PagingVO pagingVO) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("start", pagingVO.getStart());
		return mybatis.selectList("orderManagementDAO.orderList", map);
	}

	public void insertPoint(String userId,int waitingPoint) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("point", waitingPoint);
		mybatis.insert("orderManagementDAO.insertPoint",map);
	}
	public void deletePoint(String userId,int waitingPoint) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("point", waitingPoint);
		mybatis.insert("orderManagementDAO.deletePoint",map);
	}
	
	public List<OrderManagementVO> getOrder(OrderManagementVO orderManagementVO) {
		return mybatis.selectList("orderManagementDAO.getOrder", orderManagementVO);
	}

	public OrderManagementVO getOrderInfo(OrderManagementVO orderManagementVO) {
		return mybatis.selectOne("orderManagementDAO.getOrderInfo",orderManagementVO);
	}
	public Object selectOrder_start(OrderManagementVO orderManagementVO) {
		return mybatis.update("orderManagementDAO.selectOrder_start", orderManagementVO);
	}

	public Object selectOrder(OrderManagementVO orderManagementVO) {
		return mybatis.update("orderManagementDAO.selectOrder", orderManagementVO);
	}

	
}

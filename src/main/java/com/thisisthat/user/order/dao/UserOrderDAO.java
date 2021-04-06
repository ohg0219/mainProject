
package com.thisisthat.user.order.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.user.order.vo.UserOrderVO;
import com.thisisthat.util.PagingVO;

@Repository
public class UserOrderDAO {

	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public int getOrderCount(UserOrderVO vo) {
		return sessionTemplate.selectOne("myOrderDAO.getOrderCount",vo);
	}
	
	
	public List<UserOrderVO> getOrderList(UserOrderVO vo,PagingVO pagingVO){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", vo.getUserId());
		map.put("sDate", vo.getsDate());
		map.put("eDate", vo.geteDate());
		map.put("start", pagingVO.getStart());
		return sessionTemplate.selectList("myOrderDAO.getOrderList",map);
	}
	
	public List<UserOrderVO> getOrder(int orderNo) {
		return sessionTemplate.selectList("myOrderDAO.getOrder",orderNo);
	}
	
	public String getPassword(int orderNo) {
		return sessionTemplate.selectOne("myOrderDAO.getPassword",orderNo);
	}
	
	public void updateState(int orderNo,String state) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("orderNo", orderNo);
		map.put("state", state);
		sessionTemplate.update("myOrderDAO.updateState",map);
	}
}

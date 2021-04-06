package com.thisisthat.admin.usermanagement.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.util.PagingVO;

@Repository
public class UserManagementDAO {
		
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<UserVO> getUserList(UserVO vo, PagingVO paging) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("select", vo.getSelect());
		map.put("search", vo.getSearch());
		map.put("start", paging.getStart());
		map.put("cntPerPage", paging.getCntPerPage());
		return mybatis.selectList("UserManagementDAO.getUserList", map);
	}
	
	public UserVO getUser(String id) {
		return mybatis.selectOne("UserManagementDAO.getUser", id);
	}
	
	public List<UserVO> getStaffList(UserVO vo, PagingVO paging) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("select", vo.getSelect());
		map.put("search", vo.getSearch());
		map.put("start", paging.getStart());
		map.put("cntPerPage", paging.getCntPerPage());
		return mybatis.selectList("UserManagementDAO.getStaffList", map);
	}

	public UserVO getStaff(String id) {
		return mybatis.selectOne("UserManagementDAO.getStaff",id);
	}
	
	public void getUserUpdate(UserVO vo) {
		mybatis.update("UserManagementDAO.getUserUpdate", vo);
	}
	public int getUserCount(UserVO vo) {
		return mybatis.selectOne("UserManagementDAO.getUserCount", vo);
	}
	public int getStaffCount(UserVO vo) {
		return mybatis.selectOne("UserManagementDAO.getStaffCount", vo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

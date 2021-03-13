package com.thisisthat.admin.usermanagement.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.admin.usermanagement.vo.UserVO;

@Repository
public class UserManagementDAO {
		
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<UserVO> getUserList(UserVO vo) {
		return mybatis.selectList("UserManagementDAO.getUserList1", vo);
	}
	
	public UserVO getUser(String id) {
		return mybatis.selectOne("UserManagementDAO.getUser1", id);
	}
	
	public List<UserVO> getStaffList(UserVO vo) {
		return mybatis.selectList("UserManagementDAO.getStaffList", vo);
	}

	public UserVO getStaff(String id) {
		return mybatis.selectOne("UserManagementDAO.getStaff",id);
	}
	
	public void getUserUpdate(UserVO vo) {
		mybatis.update("UserManagementDAO.getUserUpdate", vo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

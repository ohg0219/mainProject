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
		return mybatis.selectList("UserManagementDAO.getUserList", vo);
	}
	
	
	
	
	
}

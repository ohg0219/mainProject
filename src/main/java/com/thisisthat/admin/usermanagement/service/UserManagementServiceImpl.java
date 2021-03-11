package com.thisisthat.admin.usermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.usermanagement.dao.UserManagementDAO;
import com.thisisthat.admin.usermanagement.vo.UserVO;

@Service
public class UserManagementServiceImpl implements UserManagementService{
	
	@Autowired
	private UserManagementDAO userDAO;
	
	
	@Override
	public List<UserVO> getUserList(UserVO vo) {
		System.out.println("임플");
		return userDAO.getUserList(vo);
	}


	@Override
	public UserVO UserManagement(String id) {
		return userDAO.getUser(id);
	}

	
}

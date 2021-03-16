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
		return userDAO.getUserList(vo);
	}

	@Override
	public UserVO userManagement(String id) {
		return userDAO.getUser(id);
	}
	
	@Override
	public List<UserVO> staffList(UserVO vo) {
		return userDAO.getStaffList(vo);
	}
	
	@Override
	public UserVO staffManagement(String id) {
		return userDAO.getStaff(id);
	}

	@Override
	public void userUpdate(UserVO vo) {
		userDAO.getUserUpdate(vo);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}

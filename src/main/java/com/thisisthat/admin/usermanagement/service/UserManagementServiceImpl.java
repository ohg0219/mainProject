package com.thisisthat.admin.usermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.usermanagement.dao.UserManagementDAO;
import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.util.PagingVO;

@Service
public class UserManagementServiceImpl implements UserManagementService{
	
	@Autowired
	private UserManagementDAO userDAO;
	
	
	@Override
	public List<UserVO> getUserList(UserVO vo, PagingVO paging) {
		return userDAO.getUserList(vo, paging);
	}

	@Override
	public UserVO userManagement(String id) {
		return userDAO.getUser(id);
	}
	
	@Override
	public List<UserVO> staffList(UserVO vo, PagingVO paging) {
		return userDAO.getStaffList(vo,paging);
	}
	
	@Override
	public UserVO staffManagement(String id) {
		return userDAO.getStaff(id);
	}

	@Override
	public void userUpdate(UserVO vo) {
		userDAO.getUserUpdate(vo);
	}

	@Override
	public int getUserCount(UserVO vo) {
		return userDAO.getUserCount(vo);
	}

	@Override
	public int getStaffCount(UserVO vo) {
		// TODO Auto-generated method stub
		return userDAO.getStaffCount(vo);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}

package com.thisisthat.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.dao.AdminDAO;
import com.thisisthat.admin.usermanagement.vo.UserVO;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminDAO dao;
	
	@Override
	public UserVO idCheck(String userId) {
		return dao.idCheck(userId);
	}

}

package com.thisisthat.user.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.user.login.dao.UserLoginOutDAO;

@Service
public class UserLoginOutServiceImpl implements UserLoginOutService {

	@Autowired
	private UserLoginOutDAO userLoginOutDAO;
	
	@Override
	public String userLogin(String userId) {
		return userLoginOutDAO.userLogin(userId);
	}

	
}

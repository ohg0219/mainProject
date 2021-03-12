package com.thisisthat.user.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.user.register.dao.UserLoginOutDAO;

@Service
public class UserLoginOutServiceImpl implements UserLoginOutService {

	@Autowired
	private UserLoginOutDAO userLoginDAO;
	
	@Override
	public String userLogin(String userId) {
		return userLoginDAO.userLogin(userId);
	}
	
}

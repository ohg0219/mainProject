package com.thisisthat.user.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.user.register.dao.UserRegisterDAO;
import com.thisisthat.user.register.vo.UserRegisterVO;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {

	@Autowired
	private UserRegisterDAO userRegisterDAO;
	
	public int idCheck(String userId) {
		return userRegisterDAO.idCheck(userId);
	}

	@Override
	public void welCome(UserRegisterVO registerVO) {
	//	userRegisterDAO.wel
		
	}
	
	
	
	
	
}

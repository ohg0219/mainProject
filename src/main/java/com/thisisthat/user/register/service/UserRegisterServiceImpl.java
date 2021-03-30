package com.thisisthat.user.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.terms.vo.InformationVO;
import com.thisisthat.admin.terms.vo.UtilizationVO;
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
	public int nickNameCheck(String nickName) {
		return userRegisterDAO.nickNameCheck(nickName);
	}

	@Override
	public void insertUser(UserRegisterVO vo) {
		userRegisterDAO.insertUser(vo);
	}

	@Override
	public InformationVO getTopInformation() {
		return userRegisterDAO.getTopInformation();
		
	}

	@Override
	public UtilizationVO getToputilization() {
		return userRegisterDAO.getToputilization();
	}

	
}

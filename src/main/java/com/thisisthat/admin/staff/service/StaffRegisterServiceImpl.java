package com.thisisthat.admin.staff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.staff.dao.StaffRegisterDAO;
import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.user.register.vo.UserRegisterVO;

@Service
public class StaffRegisterServiceImpl implements StaffRegisterService {

	
	@Autowired
	StaffRegisterDAO dao;
	
	@Override
	public void insertStaff(UserRegisterVO vo) {
		dao.insertStaff(vo);

	}

	@Override
	public void modifyStaff(UserVO vo) {
		dao.modifyStaff(vo);
	}

}

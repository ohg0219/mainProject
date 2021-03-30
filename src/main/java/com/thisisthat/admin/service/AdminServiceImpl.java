package com.thisisthat.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.banner.vo.BannerVO;
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

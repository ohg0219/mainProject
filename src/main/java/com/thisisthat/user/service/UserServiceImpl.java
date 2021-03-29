package com.thisisthat.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.banner.vo.BannerVO;
import com.thisisthat.user.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO dao;
	
	@Override
	public List<BannerVO> getBannerList() {
		
		return dao.getBannerList();
	}

}

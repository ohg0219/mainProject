package com.thisisthat.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.banner.vo.BannerVO;
import com.thisisthat.admin.terms.vo.InformationVO;
import com.thisisthat.admin.terms.vo.UtilizationVO;
import com.thisisthat.user.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO dao;
	
	@Override
	public List<BannerVO> getBannerList(String state) {
		
		return dao.getBannerList(state);
	}

	@Override
	public UtilizationVO getUtilization() {
		
		return dao.getUtilization();
	}

	@Override
	public InformationVO getPrivacy() {
		
		return dao.getPrivacy();
	}

}

package com.thisisthat.user.mypage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.user.mypage.dao.MyPageDAO;
import com.thisisthat.user.mypage.vo.MyPageVO;
import com.thisisthat.user.register.vo.UserRegisterVO;

@Service
public class MyPageServiceImpl implements MyPageService {

	@Autowired
	private MyPageDAO dao;
	
	@Override
	public UserRegisterVO modifyView(String id) {
		return dao.modifyView(id);
	}

	@Override
	public void modify(UserRegisterVO vo) {
		dao.modify(vo);
	}

	@Override
	public void delUser(UserRegisterVO vo) {
		dao.delUser(vo);
	}
	
	@Override
	public MyPageVO getMypage(String userId) {
		return dao.getMyMain(userId);
	}
	 
	
	
	
}

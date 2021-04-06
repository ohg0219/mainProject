package com.thisisthat.user.mypage.dao;

import java.util.Date;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.user.mypage.vo.MyPageVO;
import com.thisisthat.user.register.vo.UserRegisterVO;

@Repository
public class MyPageDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public UserRegisterVO modifyView(String id) {
		return mybatis.selectOne("MyPageDAO.modifyView", id);
	}
	
	public void modify(UserRegisterVO vo) {
		mybatis.update("MyPageDAO.modify", vo);
	}
	public void delUser(UserRegisterVO vo) {
		vo.setUser_role(200);
		vo.setOutDate(new Date());
		mybatis.update("MyPageDAO.delUser",vo);
	}
	
	public MyPageVO getMyMain(String userId) {
		return mybatis.selectOne("MyPageDAO.getMypage", userId);
	}
	
	
	
}

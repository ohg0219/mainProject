package com.thisisthat.user.mypage.dao;

import java.util.Date;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.user.register.vo.UserRegisterVO;

@Repository
public class MyPageDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public UserRegisterVO modifyView(String id) {
		return mybatis.selectOne("MyPage.modifyView", id);
	}
	
	public void modify(UserRegisterVO vo) {
		mybatis.update("MyPage.modify", vo);
	}
	public void delUser(UserRegisterVO vo) {
		vo.setUser_role(200);
		vo.setOutDate(new Date());
		mybatis.update("MyPage.delUser",vo);
	}
	
	
	
	
}

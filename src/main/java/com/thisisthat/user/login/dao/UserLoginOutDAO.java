package com.thisisthat.user.login.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserLoginOutDAO {

	@Autowired
	private SqlSessionTemplate userLoginOutTemplate;
	
	public String userLogin(String userId) {
		String result = userLoginOutTemplate.selectOne("UserLogin.loginCheck",userId);
		return result;
	}
}

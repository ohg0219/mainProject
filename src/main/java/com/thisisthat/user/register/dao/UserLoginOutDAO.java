package com.thisisthat.user.register.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserLoginOutDAO {

	@Autowired
	SqlSessionTemplate userLoginTemplate;
	
	public String userLogin(String userId) {
		String result = userLoginTemplate.selectOne("UserLogin.loginCheck",userId);
		return result;
	}
}

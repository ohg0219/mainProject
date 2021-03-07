package com.thisisthat.user.register.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRegisterDAO {

	@Autowired
	private SqlSessionTemplate userRegisterTemplate;
	
	public int idCheck(String userId) {
		int result = userRegisterTemplate.selectOne("UserRegister.idCheck",userId);
		return result;
	}
}

package com.thisisthat.user.phone.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PhoneDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<String> findIdPhone(Map<String, Object> map) {
		return mybatis.selectList("FindIdPasswordDAO.findIdPhone", map);
	}
	
	public String findPwPhone(Map<String, Object> map) {
		return mybatis.selectOne("FindIdPasswordDAO.findPwPhone", map);
	}
	
	public void updatePw(Map<String, Object> map) {
		mybatis.update("FindIdPasswordDAO.updatePw", map);
	}
	
}

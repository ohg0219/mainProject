package com.thisisthat.user.email.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("emailDao")
public class EmailDAO  {
	
	@Autowired
	SqlSessionTemplate template;
	
	public List<String> getIdEmail(Map<String, Object> map) {
		return template.selectList("FindIdPasswordDAO.findIdEmail", map);
	}
	
	public String getPwEmail(Map<String, Object> map) {
		return template.selectOne("FindIdPasswordDAO.findPwEmail", map);
	}
	
	public void updatePw(Map<String, Object> map) {
		template.update("FindIdPasswordDAO.updatePw", map);
	}
	
	
	
	
	
}
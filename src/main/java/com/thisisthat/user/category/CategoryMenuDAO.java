package com.thisisthat.user.category;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryMenuDAO {

	@Autowired
	SqlSessionTemplate template;
	
	public List<String> getCategoryList() {
		return template.selectList("AdminDAO.getCategory");
		
		
	}

	
	
	
}

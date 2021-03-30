package com.thisisthat.admin.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.admin.banner.vo.BannerVO;
import com.thisisthat.admin.usermanagement.vo.UserVO;

@Repository
public class AdminDAO {
	@Autowired
	private SqlSessionTemplate adminTemplate;
	
	public UserVO idCheck(String userId) {
		return adminTemplate.selectOne("AdminDAO.getUser" , userId);
	}

	
	
}

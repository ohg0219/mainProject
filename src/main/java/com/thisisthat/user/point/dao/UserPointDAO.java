package com.thisisthat.user.point.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.user.point.vo.UserPointVO;

@Repository
public class UserPointDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	public List<UserPointVO> pointList(UserPointVO userPointVO) {
		
		return mybatis.selectList("userPointDAO.pointList",userPointVO);
	}
	

	
	
	
}//end class

package com.thisisthat.admin.staff.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.user.register.vo.UserRegisterVO;

@Repository
public class StaffRegisterDAO {
	@Autowired
	SqlSessionTemplate staffTemplate;
	
	public void insertStaff(UserRegisterVO vo) {
		staffTemplate.insert("AdminRegister.insertStaff", vo);
	}
	public void modifyStaff(UserVO vo) {
		staffTemplate.update("AdminRegister.modifyStaff", vo);
	}

}

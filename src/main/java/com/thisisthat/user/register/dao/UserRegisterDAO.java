package com.thisisthat.user.register.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.admin.terms.vo.InformationVO;
import com.thisisthat.admin.terms.vo.UtilizationVO;
import com.thisisthat.user.register.vo.UserRegisterVO;

@Repository
public class UserRegisterDAO {

	@Autowired
	private SqlSessionTemplate userRegisterTemplate;
	
	public int idCheck(String userId) {
		int result = userRegisterTemplate.selectOne("UserRegister.idCheck",userId);
		return result;
	}
	
	public int nickNameCheck(String nickName) {
		int result = userRegisterTemplate.selectOne("UserRegister.nickNameCheck",nickName);
		return result;
	}
	
	public void insertUser(UserRegisterVO vo) {
		userRegisterTemplate.insert("UserRegister.insertUser",vo);
		userRegisterTemplate.insert("UserRegister.insertCoupon",vo);
		userRegisterTemplate.insert("UserRegister.insertPoint",vo);
	}
	
	public InformationVO getTopInformation() {
		return userRegisterTemplate.selectOne("termsDAO.getTopInformation");
		
	}
	public UtilizationVO getToputilization() {
		return userRegisterTemplate.selectOne("termsDAO.getTopUtilization");
	}
	
}

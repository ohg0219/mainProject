package com.thisisthat.user.register.service;

import com.thisisthat.admin.terms.vo.InformationVO;
import com.thisisthat.admin.terms.vo.UtilizationVO;
import com.thisisthat.user.register.vo.UserRegisterVO;

public interface UserRegisterService {

	int idCheck(String userId);
	int nickNameCheck(String nickName);
	void insertUser(UserRegisterVO vo);
	InformationVO getTopInformation();
	UtilizationVO getToputilization();
	
}

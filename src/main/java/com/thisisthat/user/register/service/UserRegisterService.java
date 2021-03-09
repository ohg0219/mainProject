package com.thisisthat.user.register.service;

import com.thisisthat.user.register.vo.UserRegisterVO;

public interface UserRegisterService {

	int idCheck(String userId);
	int nickNameCheck(String nickName);
	void insertUser(UserRegisterVO vo);
}

package com.thisisthat.user.register.service;

import com.thisisthat.user.register.vo.UserRegisterVO;

public interface UserRegisterService {

	int idCheck(String userId);
	
	void welCome(UserRegisterVO registerVO);
	
}

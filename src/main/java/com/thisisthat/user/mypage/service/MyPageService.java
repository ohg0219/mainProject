package com.thisisthat.user.mypage.service;

import com.thisisthat.user.register.vo.UserRegisterVO;

public interface MyPageService {

	UserRegisterVO modifyView(String id);	

	void modify(UserRegisterVO vo);
	
}
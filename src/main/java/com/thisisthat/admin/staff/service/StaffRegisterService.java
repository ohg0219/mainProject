package com.thisisthat.admin.staff.service;

import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.user.register.vo.UserRegisterVO;

public interface StaffRegisterService {
	void insertStaff(UserRegisterVO vo); 
	void modifyStaff(UserVO vo);
	
}

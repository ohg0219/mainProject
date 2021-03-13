package com.thisisthat.admin.usermanagement.service;

import java.util.List;

import com.thisisthat.admin.usermanagement.vo.UserVO;

public interface UserManagementService {

	List<UserVO> getUserList(UserVO vo);
	UserVO userManagement(String id);
	List<UserVO> staffList(UserVO vo);
	UserVO staffManagement(String id);
	void userUpdate(UserVO vo);
	
	
}

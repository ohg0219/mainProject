package com.thisisthat.admin.usermanagement.service;

import java.util.List;

import com.thisisthat.admin.usermanagement.vo.UserVO;

public interface UserManagementService {

	List<UserVO> getUserList(UserVO vo);
	UserVO UserManagement(String id);
}

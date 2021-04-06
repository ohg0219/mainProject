package com.thisisthat.admin.usermanagement.service;

import java.util.List;

import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.util.PagingVO;

public interface UserManagementService {

	List<UserVO> getUserList(UserVO vo, PagingVO paging);
	int getUserCount(UserVO vo);
	int getStaffCount(UserVO vo);
	UserVO userManagement(String id);
	List<UserVO> staffList(UserVO vo, PagingVO paging);
	UserVO staffManagement(String id);
	void userUpdate(UserVO vo);
	
	
}

package com.thisisthat.admin.role.service;

import java.util.List;

import com.thisisthat.admin.board.vo.SearchVO;
import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.util.PagingVO;

public interface RoleService {
	int getTotal(SearchVO search);
	List<UserVO> getUserList(SearchVO search, PagingVO paging);
	void updateRole(UserVO user);
	
}

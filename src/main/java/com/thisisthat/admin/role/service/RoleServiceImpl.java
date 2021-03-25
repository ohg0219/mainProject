package com.thisisthat.admin.role.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.board.vo.SearchVO;
import com.thisisthat.admin.role.dao.RoleDAO;
import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.util.PagingVO;

@Service
public class RoleServiceImpl implements RoleService {
	
	
	@Autowired
	RoleDAO roleDAO;
	
	@Override
	public int getTotal(SearchVO search) {
		return roleDAO.getTotal(search);
	}

	@Override
	public List<UserVO> getUserList(SearchVO search, PagingVO paging) {
		return roleDAO.getUserList(search, paging);
	}

	@Override
	public void updateRole(UserVO user) {
		roleDAO.updateRole(user);
	}

}

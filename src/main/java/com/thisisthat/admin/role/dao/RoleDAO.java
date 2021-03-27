package com.thisisthat.admin.role.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.admin.board.vo.SearchVO;
import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.util.PagingVO;

@Repository
public class RoleDAO {
	@Autowired
	SqlSessionTemplate roleTemplate;
	
	public int getTotal(SearchVO search) {
		return roleTemplate.selectOne("roleDAO.getTotal",search);
	}

	public List<UserVO> getUserList(SearchVO search, PagingVO paging) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parameter", search.getParameter());
		map.put("searchType", search.getSearchType());
		map.put("cntPerPage", paging.getCntPerPage());
		map.put("start", paging.getStart());
		
		return roleTemplate.selectList("roleDAO.getUserList",map);
	}

	public void updateRole(UserVO user) {
		
		roleTemplate.update("roleDAO.updateRole",user);
	}
}

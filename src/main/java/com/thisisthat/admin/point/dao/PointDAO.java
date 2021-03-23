package com.thisisthat.admin.point.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.admin.board.vo.SearchVO;
import com.thisisthat.admin.point.vo.PointVO;
import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.util.PagingVO;
@Repository
public class PointDAO {
	@Autowired
	SqlSessionTemplate pointTemplate;
	
	public PointVO getPoint(String userId) {
		
		return pointTemplate.selectOne("PointDAO.getPoint",userId);
	}

	public List<UserVO> getUserList(PagingVO vo, SearchVO search) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cntPerPage",vo.getCntPerPage());
		map.put("start", vo.getStart());
		map.put("searchType", search.getSearchType());
		map.put("parameter", search.getParameter());
		return pointTemplate.selectList("PointDAO.getUserList",map);
	}
	public void insertOnePoint(PointVO vo) {
		pointTemplate.insert("PointDAO.insertOnePoint",vo);

	}
	public void insertPoints(PointVO vo) {
		pointTemplate.insert("PointDAO.insertUsers");
		pointTemplate.update("PointDAO.updatePoints",vo);
		
	}
	public int getTotal(SearchVO vo) {
		return pointTemplate.selectOne("PointDAO.getTotal",vo);
	}
	public UserVO getUser(String userId) {
		return pointTemplate.selectOne("PointDAO.getUser",userId);
	}
	public List<PointVO> getPoints(String userId, PagingVO paging) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("start",paging.getStart());
		map.put("cntPerPage",paging.getCntPerPage());
		return pointTemplate.selectList("PointDAO.getPoints",map);
	}
	public void deletePoint(PointVO vo) {
		pointTemplate.delete("PointDAO.deletePoint",vo);
	}
	public int getPointCount(String userId) {
		return pointTemplate.selectOne("PointDAO.getPointCount",userId);
	}
}

package com.thisisthat.admin.point.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.board.vo.SearchVO;
import com.thisisthat.admin.point.dao.PointDAO;
import com.thisisthat.admin.point.vo.PointVO;
import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.util.PagingVO;

@Service
public class PointServiceImpl implements PointService {
	@Autowired
	PointDAO pointDAO;
	
	@Override
	public PointVO getPoint(String userid) {
		
		return pointDAO.getPoint(userid);
	}

	@Override
	public List<UserVO> getUserList(PagingVO vo, SearchVO search) {
		
		return pointDAO.getUserList(vo,search);
	}

	@Override
	public void insertOnePoint(PointVO vo) {
		pointDAO.insertOnePoint(vo);
	}

	@Override
	public void insertPoints(PointVO vo) {
		pointDAO.insertPoints(vo);
		
	}

	@Override
	public int getTotal(SearchVO vo) {
		return pointDAO.getTotal(vo);
	}

	@Override
	public UserVO getUser(String userId) {
		return pointDAO.getUser(userId);
	}

	@Override
	public List<PointVO> getPoints(String userid, PagingVO paging) {
		return pointDAO.getPoints(userid, paging);
	}

	@Override
	public void deletePoint(PointVO vo) {
		pointDAO.deletePoint(vo);
	}

	@Override
	public int getPointCount(String userId) {
		return pointDAO.getPointCount(userId);
	}

}

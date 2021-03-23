package com.thisisthat.admin.point.service;

import java.util.List;

import com.thisisthat.admin.board.vo.SearchVO;
import com.thisisthat.admin.point.vo.PointVO;
import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.util.PagingVO;

public interface PointService {
	UserVO getUser(String userId);
	PointVO getPoint(String userid);
	List<PointVO> getPoints(String userid, PagingVO paging);
	List<UserVO> getUserList(PagingVO vo, SearchVO search);
	void insertOnePoint(PointVO vo);
	void insertPoints(PointVO vo);
	int getTotal(SearchVO vo);
	void deletePoint(PointVO vo);
	int getPointCount(String userId);
	
}

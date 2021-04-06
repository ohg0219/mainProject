package com.thisisthat.user.point.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.user.point.dao.UserPointDAO;
import com.thisisthat.user.point.vo.UserPointVO;

@Service("UserPointService")
public class UserPointServiceImpl implements UserPointService {

	@Autowired
	private UserPointDAO userPointDAO;

	@Override
	public List<UserPointVO> pointList(UserPointVO userPointVO) {	
		return userPointDAO.pointList(userPointVO);
	}

	@Override
	public UserPointVO pointsum(UserPointVO userPointVO) {
		return userPointDAO.pointSum(userPointVO);
	}

	@Override
	public UserPointVO usingSum(UserPointVO userPointVO) {
		return userPointDAO.usingSum(userPointVO);
	}

	@Override
	public UserPointVO totalPoint(UserPointVO userPointVO) {
		return userPointDAO.totalPoint(userPointVO);
	}

	@Override
	public UserPointVO namePoint(UserPointVO userPointVO) {
		return userPointDAO.namePoint(userPointVO);
	}
	
	
}//end class
